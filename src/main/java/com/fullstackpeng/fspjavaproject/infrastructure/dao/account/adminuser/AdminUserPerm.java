package com.fullstackpeng.fspjavaproject.infrastructure.dao.account.adminuser;

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
@Table(name = "s_adminuserperm")
public class AdminUserPerm extends Auditable {
    private Long adminuserid;
    private Long permid;
}