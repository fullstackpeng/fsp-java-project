package com.fullstackpeng.fspjavaproject.infrastructure.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @project_name: fsp-java-project
 * @name: TableVO
 * @description: 表格数据
 * @author: fullstackpeng
 * @create: 2024-07-06 10:14
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableVO<T> {
    private Long total;
    private List<T> data;
}
