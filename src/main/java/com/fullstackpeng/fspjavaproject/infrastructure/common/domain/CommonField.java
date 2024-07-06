package com.fullstackpeng.fspjavaproject.infrastructure.common.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public class CommonField {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Boolean deleted = false;
}
