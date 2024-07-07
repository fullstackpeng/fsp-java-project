package com.fullstackpeng.fspjavaproject.infrastructure.security.model;

import lombok.Data;

@Data
public class LoginSuccessResponse {

    private String token;
    private String username;
}
