package com.cce.directory_service.application.ports;

import com.cce.directory_service.domain.entity.DirectoryEntity;

import java.util.List;
import java.util.Optional;

public interface DirectoryService {
    Optional<DirectoryEntity> getById(Long id);
    List<DirectoryEntity> getAll();
    DirectoryEntity create(DirectoryEntity directoryEntity);
}
