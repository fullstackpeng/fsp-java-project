package com.fullstackpeng.fspjavaproject.infrastructure.common.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @project_name: fsp-java-project
 * @name: Auditable
 * @description: 审计
 * @author: fullstackpeng
 * @create: 2024-07-06 10:37
 **/
@Getter
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
public class Auditable extends CommonField {
    @CreatedBy
    @Column(updatable = false)
    private String createBy;
    @LastModifiedBy
    private String updateBy;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createTime;
    @LastModifiedDate
    private LocalDateTime updateTime;

}
