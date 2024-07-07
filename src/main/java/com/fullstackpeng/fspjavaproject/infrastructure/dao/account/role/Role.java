package com.fullstackpeng.fspjavaproject.infrastructure.dao.account.role;

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
@Table(name = "s_role")
public class Role extends Auditable {
    private String rolename;
    private String description;
    private String rolecode;
    private Boolean enabled;
}