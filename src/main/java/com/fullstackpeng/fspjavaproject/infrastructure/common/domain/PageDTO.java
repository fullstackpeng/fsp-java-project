package com.fullstackpeng.fspjavaproject.infrastructure.common.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @project_name: fsp-java-project
 * @name: PageDTO
 * @description: 分页传参
 * @author: fullstackpeng
 * @create: 2024-07-06 09:52
 **/
@Getter
@Setter
public class PageDTO {
    private Integer pageNum;
    private Integer pageSize;

    public PageDTO() {
        this.pageNum = 1;
        this.pageSize = 10;
    }
    public PageDTO(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
    public Integer getPageNum() {
        return (this.pageNum - 1) * this.pageSize;
    }
}
