package com.fullstackpeng.fspjavaproject.infrastructure.dao.account.adminuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminUserRoleRepository extends JpaRepository<AdminUserRole, Long>, JpaSpecificationExecutor<AdminUserRole> {
}