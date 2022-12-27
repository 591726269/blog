package com.example.blog.strategy;

import com.example.blog.dto.UserInfoDTO;

/**
 * 第三方登录策略
 *
 * @author  Wuzp
 * @date 2022/12/18
 */
public interface SocialLoginStrategy {

    /**
     * 登录
     *
     * @param data 数据
     * @return {@link UserInfoDTO} 用户信息
     */
    UserInfoDTO login(String data);

}
