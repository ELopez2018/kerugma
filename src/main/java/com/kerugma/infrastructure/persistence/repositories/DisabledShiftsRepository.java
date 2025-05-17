package com.kerugma.infrastructure.persistence.repositories;

import com.kerugma.infrastructure.persistence.entities.DisabledShiftsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisabledShiftsRepository extends JpaRepository<DisabledShiftsEntity, Long> {
}
