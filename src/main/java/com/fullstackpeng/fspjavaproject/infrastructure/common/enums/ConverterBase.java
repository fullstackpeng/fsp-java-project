package com.fullstackpeng.fspjavaproject.infrastructure.common.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public abstract class ConverterBase<T extends Enum<T> & BaseEnum<T>> implements
        AttributeConverter<T,Integer> {
  private final Class<T> clazz;

  public ConverterBase(Class<T> clazz) {
    this.clazz = clazz;
  }

  @Override
  public Integer convertToDatabaseColumn(T attribute) {
    return attribute != null ? attribute.getCode() : null;
  }

  @Override
  public T convertToEntityAttribute(Integer dbData) {
    T[] enums = clazz.getEnumConstants();
    for (T e : enums) {
      if (e.getCode().equals(dbData)) {
        return e;
      }
    }
    return null;
  }
}