package com.fullstackpeng.fspjavaproject.infrastructure.security.authentication.admin.password;

import com.fullstackpeng.fspjavaproject.infrastructure.dao.account.adminuser.AdminUser;
import com.fullstackpeng.fspjavaproject.infrastructure.dao.account.adminuser.AdminUserRepository;
import com.fullstackpeng.fspjavaproject.infrastructure.security.cache.Token;
import com.fullstackpeng.fspjavaproject.infrastructure.security.cache.TokenService;
import com.fullstackpeng.fspjavaproject.infrastructure.security.enums.AuthErrorMsg;
import com.fullstackpeng.fspjavaproject.infrastructure.security.enums.LoginUserType;
import com.fullstackpeng.fspjavaproject.infrastructure.security.model.LoginSuccessToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Optional;


@Component
@Slf4j
@RequiredArgsConstructor
public class AdminPassAuthenticationProvider implements
        AuthenticationProvider {

    private final AdminUserRepository adminUserRepository;
    private final TokenService tokenService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        AdminUsernamePasswordToken adminUsernamePasswordToken = (AdminUsernamePasswordToken) authentication;
        if (ObjectUtils.isEmpty(adminUsernamePasswordToken.getUsername()) || ObjectUtils.isEmpty(adminUsernamePasswordToken.getPassword())) {
            throw new BadCredentialsException(AuthErrorMsg.passwordIncorrect.getName());
        }
        Optional<AdminUser> adminUser = adminUserRepository.findFirstByUsernameOrderByIdAsc(adminUsernamePasswordToken.getUsername());
        if (adminUser.isEmpty()) {
            throw new BadCredentialsException(AuthErrorMsg.passwordIncorrect.getName());
        } else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            boolean matches = bCryptPasswordEncoder.matches(adminUsernamePasswordToken.getPassword(), adminUser.get().getPassword());
            if (matches) {
                String token = tokenService.buildToken(adminUsernamePasswordToken.getUsername());
                tokenService.save(
                        LoginUserType.ADMIN_USER.getCode() + ":" + adminUsernamePasswordToken.getUsername(),
                        Token
                                .builder()
                                .creationDate(new Date())
                                .isValid(true)
                                .jwtExpiration(tokenService.extractExpiration(token))
                                .userId(adminUser.get().getId())
                                .username(adminUser.get().getUsername())
                                .value(token)
                                .build()
                                .toString()
                );
                return new LoginSuccessToken(token, adminUsernamePasswordToken.getUsername());
            } else {
                throw new BadCredentialsException(AuthErrorMsg.passwordIncorrect.getName());
            }
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AdminUsernamePasswordToken.class.isAssignableFrom(aClass);
    }
}
