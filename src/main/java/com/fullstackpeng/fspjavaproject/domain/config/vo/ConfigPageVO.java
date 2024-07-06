package com.fullstackpeng.fspjavaproject.domain.config.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigPageVO{
    private Long id;

    private String configKey;

    private String configValue;

    private String configDesc;
}
