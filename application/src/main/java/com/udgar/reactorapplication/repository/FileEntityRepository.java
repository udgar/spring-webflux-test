package com.udgar.reactorapplication.repository;

import com.udgar.reactorapplication.entity.FileRecordEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

public interface FileEntityRepository extends ReactiveCrudRepository<FileRecordEntity, Long> {
}
