package com.fullstackpeng.fspjavaproject.infrastructure.security.model;

import lombok.Data;

@Data
public class SmsLoginReq {
    String phone;
    String code;
}
