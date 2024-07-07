package com.fullstackpeng.fspjavaproject.controller;

import com.fullstackpeng.fspjavaproject.infrastructure.common.domain.PageDTO;
import com.fullstackpeng.fspjavaproject.infrastructure.dao.config.Config;
import com.fullstackpeng.fspjavaproject.infrastructure.dao.config.ConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequiredArgsConstructor
public class ConfigController {
    private final ConfigRepository configRepository;

    @PostMapping("add")
    public ResponseEntity<Config> add(@RequestBody Config config) {
        return ResponseEntity.ok(configRepository.save(config));
    }

    @PostMapping("edit")
    public ResponseEntity<Config> edit(@RequestBody Config configEditDTO) {
        return ResponseEntity.ok(configRepository.save(configEditDTO));
    }

    @PostMapping("delete")
    public ResponseEntity<Void> delete(@RequestBody Long id) {
        configRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping("logicDelete")
    public ResponseEntity<Void> logicDelete(@RequestBody Long id) {
        configRepository.updateDeletedById(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Config> get(@PathVariable Long id) {
        return ResponseEntity.ok(configRepository.getReferenceById(id));
    }

    @PostMapping("getByKey/{key}")
    public ResponseEntity<Config> getByKey(@PathVariable String key) {
        return ResponseEntity.ok(configRepository.findFirstByConfigKeyOrderByIdAsc(key));
    }

    @PostMapping("list")
    public ResponseEntity<List<Config>> list() {
        return ResponseEntity.ok(configRepository.findAll());
    }

    @PostMapping("page")
    public ResponseEntity<Page<Config>> page(@RequestBody PageDTO pageDTO) {
        Page<Config> all = configRepository.findAll(PageRequest.of(pageDTO.getPageNum(), pageDTO.getPageSize()));
        return ResponseEntity.ok(all);
    }
}
