package com.fullstackpeng.fspjavaproject.domain.config.dto;

import com.fullstackpeng.fspjavaproject.infrastructure.common.domain.PageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigPageDTO extends PageDTO {
    private String configKey;
}
