package com.fullstackpeng.fspjavaproject.infrastructure.dao.config;

import com.fullstackpeng.fspjavaproject.infrastructure.common.domain.Auditable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s_config")
public class Config extends Auditable {
    private String configKey;

    private String configValue;

    private String configDesc;
}
