package com.cce.directory_service.api.controllers;

import com.cce.directory_service.api.dto.request.CreateDirectoryRequestDto;
import com.cce.directory_service.application.ports.DirectoryService;
import com.cce.directory_service.domain.entity.DirectoryEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/directory")
public class DirectoryController {
    private final DirectoryService directoryService;

    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @GetMapping("{directoryId}")
    public Optional<DirectoryEntity> getById(@PathVariable Long directoryId) {
        return this.directoryService.getById(directoryId);
    }

    @GetMapping()
    public List<DirectoryEntity> getAll() {
        return this.directoryService.getAll();
    }

    @PostMapping()
    public DirectoryEntity create(@Valid @RequestBody CreateDirectoryRequestDto createDirectoryRequestDto) {
        DirectoryEntity directoryEntity = new DirectoryEntity(createDirectoryRequestDto.getPhoneNumber(), createDirectoryRequestDto.getEntityId());
        return this.directoryService.create(directoryEntity);
    }
}
