package com.fullstackpeng.fspjavaproject.infrastructure.security.model;

import lombok.Data;

@Data
public class PassLoginReq {
    String username;
    String password;
}
