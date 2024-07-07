package com.fullstackpeng.fspjavaproject.infrastructure.security.enums;


/**
 * 各种登录认证方式处理的url
 */
public enum AuthUrlEnum {

  ADMIN_PASS("/admin/auth/v1/pass", "后台用户密码登录"),
  ADMIN_SMS("/admin/auth/v1/sms", "后台用户短信验证码登录");
  ;

  AuthUrlEnum(String url, String name) {
    this.url = url;
    this.name = name;
  }


  private String url;

  public String getUrl() {
    return url;
  }

  public String getName() {
    return name;
  }

  private String name;

}
