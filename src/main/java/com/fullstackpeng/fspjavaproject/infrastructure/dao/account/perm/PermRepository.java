package com.fullstackpeng.fspjavaproject.infrastructure.dao.account.perm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PermRepository extends JpaRepository<Perm, Long>, JpaSpecificationExecutor<Perm> {
}