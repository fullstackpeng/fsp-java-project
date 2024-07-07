package com.fullstackpeng.fspjavaproject.infrastructure.dao.account.adminuser;

import com.fullstackpeng.fspjavaproject.infrastructure.common.domain.Auditable;
import com.fullstackpeng.fspjavaproject.infrastructure.dao.enums.SexEnum;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s_adminuser")
public class AdminUser extends Auditable {
    private String unionid;
    private String username;
    private String password;
    private String avatar;
    private String nickname;
    private String email;
    private String phone;
    @Convert(converter = SexEnum.Converter.class)
    private SexEnum sex;
    private String birthday;
    private Boolean enabled;
}