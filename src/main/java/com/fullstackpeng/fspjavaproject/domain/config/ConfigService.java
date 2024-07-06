package com.fullstackpeng.fspjavaproject.domain.config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.fullstackpeng.fspjavaproject.domain.config.dto.ConfigAddDTO;
import com.fullstackpeng.fspjavaproject.domain.config.dto.ConfigEditDTO;
import com.fullstackpeng.fspjavaproject.domain.config.dto.ConfigListDTO;
import com.fullstackpeng.fspjavaproject.domain.config.dto.ConfigPageDTO;
import com.fullstackpeng.fspjavaproject.domain.config.vo.*;
import com.fullstackpeng.fspjavaproject.infrastructure.common.domain.TableVO;
import com.querydsl.core.types.dsl.BooleanExpression;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @project_name: fsp-java-project
 * @name: ConfigService
 * @description: 配置服务
 * @author: fullstackpeng
 * @create: 2024-07-06 09:43
 **/
@Service
@RequiredArgsConstructor
public class ConfigService {
    private final EntityManager entityManager;
    private final CriteriaBuilderFactory criteriaBuilderFactory;
    private final ConfigRepository configRepository;

    // add
    public ConfigAddVO add(ConfigAddDTO configAddDTO) {
        Config config = BeanUtil.copyProperties(configAddDTO, Config.class);
        config = configRepository.save(config);
        return BeanUtil.copyProperties(config, ConfigAddVO.class);
    }

    // edit
    public ConfigEditVO edit(ConfigEditDTO configEditDTO) {
        Config config = configRepository.findById(configEditDTO.getId()).orElseThrow(() -> new RuntimeException("not found"));
        BeanUtil.copyProperties(configEditDTO, config);
        config = configRepository.save(config);
        return ConfigEditVO.builder().id(config.getId()).build();
    }

    // delete
    public ConfigDeleteVO delete(Long id) {
        Config config = configRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        configRepository.deleteById(id);
        return ConfigDeleteVO.builder().id(config.getId()).build();
    }

    // logic delete
    public ConfigDeleteVO logicDelete(Long id) {
        Config config = configRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        configRepository.updateDeletedById(Objects.requireNonNull(config.getId()));
        return ConfigDeleteVO.builder().id(config.getId()).build();
    }

    // get
    public ConfigGetVO get(Long id) {
        Config config = configRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return BeanUtil.copyProperties(config, ConfigGetVO.class);
    }

    // list
    public List<ConfigListVO> list(ConfigListDTO configListDTO) {
        QConfig qConfig = QConfig.config;
        BooleanExpression expression = qConfig.deleted.isFalse();
        if (Objects.nonNull(configListDTO.getConfigKey())) {
            expression = expression.and(qConfig.configKey.eq(configListDTO.getConfigKey()));
        }
        List<Config> configList = new BlazeJPAQuery<Config>(entityManager, criteriaBuilderFactory)
                .select(qConfig)
                .from(qConfig)
                .where(expression)
                .fetch();
        return BeanUtil.copyToList(configList, ConfigListVO.class);
    }

    // page
    public TableVO<ConfigPageVO> page(ConfigPageDTO configPageDTO) {
        QConfig qConfig = QConfig.config;
        BooleanExpression expression = qConfig.deleted.isFalse();
        if (Objects.nonNull(configPageDTO.getConfigKey())) {
            expression = expression.and(qConfig.configKey.like(CharSequenceUtil.center(configPageDTO.getConfigKey(), StrUtil.length(configPageDTO.getConfigKey()) + 2, "%")));
        }
        PagedList<Config> configs = new BlazeJPAQuery<Config>(entityManager, criteriaBuilderFactory)
                .select(qConfig)
                .from(qConfig)
                .where(expression)
                .fetchPage(configPageDTO.getPageNum(), configPageDTO.getPageSize());
        return new TableVO<>(configs.getTotalSize(), BeanUtil.copyToList(configs, ConfigPageVO.class));
    }

    public static void main(String[] args) {
        System.out.println(CharSequenceUtil.center("test", StrUtil.length("test") + 2, "%"));
    }
}
