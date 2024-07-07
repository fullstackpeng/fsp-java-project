package com.fullstackpeng.fspjavaproject.infrastructure.dao.account.perm;

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
@Table(name = "s_perm")
public class Perm extends Auditable {
    private String permname;
    private String description;
    private String permcode;
    private Integer permtype;
    private Long pid;
    private Boolean enabled;
}