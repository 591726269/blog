package com.example.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.UserInfoDao;
import com.example.blog.dto.UserOnlineDTO;
import com.example.blog.entity.UserInfo;
import com.example.blog.service.UserInfoService;
import com.example.blog.utils.UserUtils;
import com.example.blog.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Wuzp
 * @date 2022/12/26 16:57
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUserInfo(UserInfoVO userInfoVO) {
        //封装用户信息
        UserInfo userInfo = UserInfo.builder()
                .id(UserUtils.getLoginUser().getUserInfoId())
                .nickname(userInfoVO.getNickname())
                .intro(userInfoVO.getIntro())
                .webSite(userInfoVO.getWebSite())
                .build();
        userInfoDao.updateById(userInfo);
    }

    @Override
    public String updateUserAvatar(MultipartFile file) {
        return null;
    }

    @Override
    public void saveUserEmail(EmailVO emailVO) {

    }

    @Override
    public void updateUserRole(UserRoleVO userRoleVO) {

    }

    @Override
    public void updateUserDisable(UserDisableVO userDisableVO) {

    }

    @Override
    public PageResult<UserOnlineDTO> listOnlineUsers(ConditionVO conditionVO) {
        return null;
    }

    @Override
    public void removeOnlineUser(Integer userInfoId) {

    }
}
