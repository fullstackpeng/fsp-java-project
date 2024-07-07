package com.fullstackpeng.fspjavaproject.infrastructure.dao.account.user;

import com.fullstackpeng.fspjavaproject.infrastructure.common.domain.Auditable;
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
@Table(name = "s_user")
public class User extends Auditable {
    private String unionid;
    private String username;
    private String avatar;
    private String nickname;
    private String email;
    private String phone;
    private Integer sex;
    private String birthday;
    private Boolean enabled;
}