package com.fullstackpeng.fspjavaproject.infrastructure.dao.enums;

import com.fullstackpeng.fspjavaproject.infrastructure.common.enums.BaseEnum;
import com.fullstackpeng.fspjavaproject.infrastructure.common.enums.ConverterBase;

import java.util.Optional;

public enum SexEnum implements BaseEnum<SexEnum> {
    MALE(1, "男"),
    FEMALE(2, "女");

    Integer code;
    String name;

    SexEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


    public static Optional<SexEnum> of(Integer code) {
        return Optional.ofNullable(
                BaseEnum.parseByCode(SexEnum.class, code));
    }

    public static class Converter extends ConverterBase<SexEnum> {
        public Converter() {
            super(SexEnum.class);
        }
    }
}
