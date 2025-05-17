package com.kerugma.infrastructure.persistence.repositories;

import com.kerugma.infrastructure.persistence.entities.DesignationEntity;
import com.kerugma.infrastructure.persistence.entities.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepository extends JpaRepository<DesignationEntity, Long> {
}
