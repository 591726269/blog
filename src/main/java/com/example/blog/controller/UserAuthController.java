package com.example.blog.controller;

import com.example.blog.dto.UserBackDTO;
import com.example.blog.service.UserAuthService;
import com.example.blog.vo.ConditionVO;
import com.example.blog.vo.PageResult;
import com.example.blog.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户账号控制器
 * @author Wuzp
 * @date 2022/12/26 16:45
 */
@Api(tags = "用户账号模块")
@RestController
public class UserAuthController {
    @Autowired
    private UserAuthService userAuthService;
    /**
     * 查询后台用户列表
     *
     * @param condition 条件
     * @return {@link Result<UserBackDTO>} 用户列表
     */
    @ApiOperation(value = "查询后台用户列表")
    @GetMapping("/admin/users")
    public Result<PageResult<UserBackDTO>> listUsers(ConditionVO condition) {
        return Result.ok(userAuthService.listUserBackDTO(condition));
    }
}
