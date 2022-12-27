package com.example.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.UserAuthDao;
import com.example.blog.dao.UserInfoDao;
import com.example.blog.dao.UserRoleDao;
import com.example.blog.dto.UserAreaDTO;
import com.example.blog.dto.UserBackDTO;
import com.example.blog.dto.UserInfoDTO;
import com.example.blog.entity.UserAuth;
import com.example.blog.service.BlogInfoService;
import com.example.blog.service.RedisService;
import com.example.blog.service.UserAuthService;
import com.example.blog.utils.PageUtils;
import com.example.blog.vo.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wuzp
 * @date 2022/12/26 16:48
 */
@Service
public class UserAuthServiceImpl extends ServiceImpl<UserAuthDao, UserAuth> implements UserAuthService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserAuthDao userAuthDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private BlogInfoService blogInfoService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendCode(String username) {

    }

    @Override
    public List<UserAreaDTO> listUserAreas(ConditionVO conditionVO) {
        return null;
    }

    @Override
    public void register(UserVO user) {

    }

    @Override
    public UserInfoDTO qqLogin(QQLoginVO qqLoginVO) {
        return null;
    }

    @Override
    public UserInfoDTO weiboLogin(WeiboLoginVO weiboLoginVO) {
        return null;
    }

    @Override
    public void updatePassword(UserVO user) {

    }

    @Override
    public void updateAdminPassword(PasswordVO passwordVO) {

    }

    @Override
    public PageResult<UserBackDTO> listUserBackDTO(ConditionVO condition) {
        //获取后台用户数量
        Integer count = userAuthDao.countUser(condition);
        if (count == 0){
            return new PageResult<>();
        }
        //获取后台用户列表
        List<UserBackDTO> userBackDTOList = userAuthDao.listUsers(PageUtils.getLimitCurrent() , PageUtils.getSize(),condition);
        return new PageResult<>(userBackDTOList,count);
    }
}
