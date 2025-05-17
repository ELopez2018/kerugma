package com.kerugma.infrastructure.persistence.repositories;

import com.kerugma.infrastructure.persistence.entities.ShiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ShiftRepository extends JpaRepository<ShiftEntity, Long> {

  List<ShiftEntity> findAllByDateAndTime(LocalDate date, LocalTime time);
}
