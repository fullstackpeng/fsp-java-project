package com.fullstackpeng.fspjavaproject.controller.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/auth/v1")
public class AdminUserLoginController {

    @PostMapping("/pass")
    public String adminPassLogin() {
        return "后台用户密码登录异常，请检查系统配置";
    }

    @PostMapping("/sms")
    public String adminSmsLogin() {
        return "后台用户短信登录异常，请检查系统配置";
    }
}
