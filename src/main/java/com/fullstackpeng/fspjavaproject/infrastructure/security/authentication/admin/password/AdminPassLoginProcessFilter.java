package com.fullstackpeng.fspjavaproject.infrastructure.security.authentication.admin.password;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstackpeng.fspjavaproject.infrastructure.security.enums.AuthErrorMsg;
import com.fullstackpeng.fspjavaproject.infrastructure.security.enums.AuthUrlEnum;
import com.fullstackpeng.fspjavaproject.infrastructure.security.exception.MethodNotSupportException;
import com.fullstackpeng.fspjavaproject.infrastructure.security.model.PassLoginReq;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import java.io.IOException;

@Slf4j
public class AdminPassLoginProcessFilter extends AbstractAuthenticationProcessingFilter {


    public AdminPassLoginProcessFilter(
            AuthenticationManager authenticationManager) {
        super(AuthUrlEnum.ADMIN_PASS.getUrl(), authenticationManager);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException {
        log.info("前端请求url:{}，uri:{}", request.getRequestURL(), request.getRequestURI());
        checkMethod(request);
        ObjectMapper mapper = new ObjectMapper();
        PassLoginReq loginReq = mapper.readValue(request.getReader(),
                PassLoginReq.class);
        AdminUsernamePasswordToken token = new AdminUsernamePasswordToken(loginReq.getUsername(), loginReq.getPassword());
        return this.getAuthenticationManager().authenticate(token);
    }


    public void checkMethod(HttpServletRequest request) {
        if (!HttpMethod.POST.name().equals(request.getMethod())) {
            throw new MethodNotSupportException(AuthErrorMsg.methodNotSupport.getName());
        }
    }


}
