package com.fullstackpeng.fspjavaproject.controller.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/auth/v1")
public class UserAuthController {

    @PostMapping("/pass")
    public String userPass() {
        return "用户名密码登录失败，请检查配置";
    }

    @PostMapping("/sms")
    public String userSms() {
        return "用户名短信登录失败，请检查配置";
    }
}
