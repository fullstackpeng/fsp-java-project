package com.fullstackpeng.fspjavaproject.infrastructure.dao.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config, Long>, JpaSpecificationExecutor<Config> {
    @Transactional
    @Modifying
    @Query("update Config c set c.deleted = true where c.id = ?1")
    void updateDeletedById(@NonNull Long id);

    Config findFirstByConfigKeyOrderByIdAsc(@NonNull String configKey);
}
