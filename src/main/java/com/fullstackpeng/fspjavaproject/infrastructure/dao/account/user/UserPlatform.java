package com.fullstackpeng.fspjavaproject.infrastructure.dao.account.user;

import com.fullstackpeng.fspjavaproject.infrastructure.common.domain.Auditable;
import com.fullstackpeng.fspjavaproject.infrastructure.security.enums.LoginUserType;
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
@Table(name = "s_userplatform")
public class UserPlatform extends Auditable {
    private Long adminuserid;
    private Long platformid;
    @Convert(converter = LoginUserType.Converter.class)
    private LoginUserType logintype;
    private String openid;
    private String extra;
}