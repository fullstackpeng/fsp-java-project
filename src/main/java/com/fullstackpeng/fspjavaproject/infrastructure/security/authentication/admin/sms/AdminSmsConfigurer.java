package com.fullstackpeng.fspjavaproject.infrastructure.security.authentication.admin.sms;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

public class AdminSmsConfigurer extends AbstractHttpConfigurer<AdminSmsConfigurer, HttpSecurity> {


    @Override
    public void init(HttpSecurity builder) throws Exception {
        super.init(builder);
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        super.configure(builder);
    }

    public static AdminSmsConfigurer adminSmsConfigurer() {
        return new AdminSmsConfigurer();
    }

}
