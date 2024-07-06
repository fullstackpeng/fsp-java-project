package com.fullstackpeng.fspjavaproject.controller;

import com.fullstackpeng.fspjavaproject.domain.config.ConfigService;
import com.fullstackpeng.fspjavaproject.domain.config.dto.ConfigAddDTO;
import com.fullstackpeng.fspjavaproject.domain.config.dto.ConfigEditDTO;
import com.fullstackpeng.fspjavaproject.domain.config.dto.ConfigListDTO;
import com.fullstackpeng.fspjavaproject.domain.config.dto.ConfigPageDTO;
import com.fullstackpeng.fspjavaproject.domain.config.vo.*;
import com.fullstackpeng.fspjavaproject.infrastructure.common.domain.TableVO;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @project_name: fsp-java-project
 * @name: ConfigController
 * @description: config 控制器
 * @author: fullstackpeng
 * @create: 2024-07-06 11:15
 **/
@RestController
@RequestMapping("config/v1")
public class ConfigController {
    @Resource
    private ConfigService configService;

    @PostMapping("add")
    public ResponseEntity<ConfigAddVO> add(@RequestBody ConfigAddDTO configAddDTO) {
        return ResponseEntity.ok(configService.add(configAddDTO));
    }

    @PostMapping("edit")
    public ResponseEntity<ConfigEditVO> edit(@RequestBody ConfigEditDTO configEditDTO) {
        return ResponseEntity.ok(configService.edit(configEditDTO));
    }

    @PostMapping("delete")
    public ResponseEntity<ConfigDeleteVO> delete(@RequestBody Long id) {
        return ResponseEntity.ok(configService.delete(id));
    }

    @PostMapping("logicDelete")
    public ResponseEntity<ConfigDeleteVO> logicDelete(@RequestBody Long id) {
        return ResponseEntity.ok(configService.logicDelete(id));
    }

    @PostMapping("get")
    public ResponseEntity<ConfigGetVO> get(@RequestBody Long id) {
        return ResponseEntity.ok(configService.get(id));
    }

    @PostMapping("list")
    public ResponseEntity<List<ConfigListVO>> list(@RequestBody ConfigListDTO configListDTO) {
        return ResponseEntity.ok(configService.list(configListDTO));
    }

    @PostMapping("page")
    public ResponseEntity<TableVO<ConfigPageVO>> page(@RequestBody ConfigPageDTO configPageDTO) {
        return ResponseEntity.ok(configService.page(configPageDTO));
    }
}
