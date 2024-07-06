package com.fullstackpeng.fspjavaproject.infrastructure.common.domain;

import cn.hutool.core.util.IdUtil;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class MyGenerator
  implements IdentifierGenerator, Configurable {

    private String prefix;

    @Override
    public Serializable generate(
            SharedSessionContractImplementor session, Object obj)
      throws HibernateException {
        return prefix + IdUtil.getSnowflakeNextIdStr();
    }

    @Override
    public void configure(Type type, Properties properties,
                          ServiceRegistry serviceRegistry) throws MappingException {
        prefix = properties.getProperty("spring.application.name");
    }
}
