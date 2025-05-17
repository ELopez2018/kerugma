package com.kerugma.infrastructure.persistence.repositories;

import com.kerugma.infrastructure.persistence.entities.CongregationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CongregationRepository extends JpaRepository<CongregationEntity, Long> {
}
