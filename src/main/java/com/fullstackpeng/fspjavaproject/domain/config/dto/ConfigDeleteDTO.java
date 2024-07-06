package com.fullstackpeng.fspjavaproject.domain.config.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigDeleteDTO {

    private Long id;
}
