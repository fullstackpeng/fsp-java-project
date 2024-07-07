package com.fullstackpeng.fspjavaproject.infrastructure.security.authentication.admin.password;

import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AdminPassConfigurer extends AbstractHttpConfigurer<AdminPassConfigurer, HttpSecurity> {


    @Override
    public void init(HttpSecurity builder) throws Exception {
        super.init(builder);
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        ApplicationContext applicationContext = builder.getSharedObject(ApplicationContext.class);
        AuthenticationManagerBuilder authenticationManagerBuilder = builder.getSharedObject(AuthenticationManagerBuilder.class);
        AdminPassLoginProcessFilter adminPassLoginProcessFilter = new AdminPassLoginProcessFilter(authenticationManagerBuilder.getObject());
        AuthenticationSuccessHandler authenticationSuccessHandler = applicationContext.getBean(AuthenticationSuccessHandler.class);
        AuthenticationFailureHandler authenticationFailureHandler = applicationContext.getBean(AuthenticationFailureHandler.class);
        adminPassLoginProcessFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        adminPassLoginProcessFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        builder.addFilterBefore(adminPassLoginProcessFilter, UsernamePasswordAuthenticationFilter.class);
        super.configure(builder);
    }

    public static AdminPassConfigurer adminPassConfigurer() {
        return new AdminPassConfigurer();
    }

}
