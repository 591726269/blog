package com.example.blog.service.impl;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.blog.dao.*;
import com.example.blog.service.BlogInfoService;
import com.example.blog.service.RedisService;
import com.example.blog.utils.IpUtils;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.example.blog.constant.CommonConst.*;
import static com.example.blog.constant.RedisPrefixConst.*;

/**
 * @author Wuzp
 * @date 2022/12/26 9:53
 */
@Service
public class BlogInfoServiceImpl implements BlogInfoService {
    @Resource
    private HttpServletRequest request;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private TagDao tagDao;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private RedisService redisService;
    @Autowired
    private WebsiteConfigDao websiteConfigDao;

    public void report() {
        // 获取ip
        String ipAddress = IpUtils.getIpAddress(request);
        // 获取访问设备
        UserAgent userAgent = IpUtils.getUserAgent(request);
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        //生成唯一标识
        String uuid = ipAddress + browser.getName() + operatingSystem.getName();
        String md5 = DigestUtils.md5DigestAsHex(uuid.getBytes());
        //判断是否访问
        if (!redisService.sIsMember(UNIQUE_VISITOR,md5)){
            // 统计游客地域分布
            String ipSource = IpUtils.getIpSource(ipAddress);
            if (StringUtils.isNotBlank(ipSource)) {
                ipSource = ipSource.substring(0, 2)
                        .replaceAll(PROVINCE, "")
                        .replaceAll(CITY, "");
                redisService.hIncr(VISITOR_AREA, ipSource, 1L);
            } else {
                redisService.hIncr(VISITOR_AREA, UNKNOWN, 1L);
            }
            // 访问量+1
            redisService.incr(BLOG_VIEWS_COUNT, 1);
            // 保存唯一标识
            redisService.sAdd(UNIQUE_VISITOR, md5);
        }

    }
}
