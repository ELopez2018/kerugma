package com.kerugma.infrastructure.persistence.repositories;

import com.kerugma.infrastructure.persistence.entities.StandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StandRepository extends JpaRepository<StandEntity, Long> {
}