package com.fullstackpeng.fspjavaproject.infrastructure.dao.account.platform;

import com.fullstackpeng.fspjavaproject.infrastructure.common.domain.Auditable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s_platform")
public class Platform extends Auditable {
    private String platformname;
    private String description;
    private String platformcode;
    private Boolean enabled;
}