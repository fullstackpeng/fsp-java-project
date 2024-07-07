package com.fullstackpeng.fspjavaproject.infrastructure.dao.account.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserPlatformRepository extends JpaRepository<UserPlatform, Long>, JpaSpecificationExecutor<UserPlatform> {
}