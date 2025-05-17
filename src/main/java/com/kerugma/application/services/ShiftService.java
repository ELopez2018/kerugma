package com.kerugma.application.services;

import com.kerugma.infrastructure.persistence.entities.DisabledShiftsEntity;
import com.kerugma.infrastructure.persistence.entities.ShiftEntity;
import com.kerugma.infrastructure.persistence.repositories.DisabledShiftsRepository;
import com.kerugma.infrastructure.persistence.repositories.ShiftRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class ShiftService {

  private final ShiftRepository repository;

  private final DisabledShiftsRepository disabledShiftsRepository;

  public ShiftService(ShiftRepository repository, DisabledShiftsRepository disabledShiftsRepository) {
    this.repository = repository;
    this.disabledShiftsRepository = disabledShiftsRepository;
  }


  public List<ShiftEntity> findAll() {
    return repository.findAll();
  }


  public Optional<ShiftEntity> findById(Long id) {
    return repository.findById(id);
  }


  public ShiftEntity save(ShiftEntity shift) {
    List<ShiftEntity> existingShifts = repository.findAllByDateAndTime(shift.getDate(), shift.getTime());

    final int MAX_SHIFTS = 3;

    // Validar si ya existe un turno igual (por ejemplo, mismo usuario, fecha y hora)
    boolean isDuplicate = existingShifts.stream()
            .anyMatch(existing -> existing.getUser().getId().equals(shift.getUser().getId()));

    if (isDuplicate) {
      throw new IllegalArgumentException("Ya existe un turno registrado para este usuario en esta fecha y hora.");
    }

    if (existingShifts.size() >= MAX_SHIFTS) {
      throw new IllegalStateException("El turno ya está completo. Debe eliminar uno para poder agregar otro.");
    }

   List<DisabledShiftsEntity>  blackList = disabledShiftsRepository.findAll();
    boolean isDisabled = blackList.stream()
            .anyMatch(existing -> existing.getTime().equals(shift.getTime()) && existing.getDate().equals(shift.getDate()) );

    if (isDisabled) {
      throw new IllegalArgumentException("El turno está deshabilitado  en esta fecha.");
    }

    return repository.save(shift);
  }


  public ShiftEntity update(Long id, ShiftEntity updated) {
    ShiftEntity existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Shift not found"));

    return repository.save(existing);
  }


  public void delete(Long id) {
    if (!repository.existsById(id)) {
      throw new RuntimeException("Shift not found");
    }
    repository.deleteById(id);
  }
}
