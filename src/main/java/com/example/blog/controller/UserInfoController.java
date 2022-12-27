package com.example.blog.controller;

import com.example.blog.annotation.OptLog;
import com.example.blog.service.UserInfoService;
import com.example.blog.vo.Result;
import com.example.blog.vo.UserRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.blog.constant.OptTypeConst.UPDATE;

/**
 * @author Wuzp
 * @date 2022/12/26 16:42
 */
@Api("用户信息模块")
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 修改用户角色
     *
     * @param userRoleVO 用户角色信息
     * @return {@link Result<>}
     */
    @OptLog(optType = UPDATE)
    @ApiOperation(value = "修改用户角色")
    @PutMapping("/admin/users/role")
    public Result<?> updateUserRole(@Valid @RequestBody UserRoleVO userRoleVO) {
        userInfoService.updateUserRole(userRoleVO);
        return Result.ok();
    }


}
