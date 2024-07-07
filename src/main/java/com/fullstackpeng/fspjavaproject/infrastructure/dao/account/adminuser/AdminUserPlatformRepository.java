package com.fullstackpeng.fspjavaproject.infrastructure.dao.account.adminuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminUserPlatformRepository extends JpaRepository<AdminUserPlatform, Long>, JpaSpecificationExecutor<AdminUserPlatform> {
}