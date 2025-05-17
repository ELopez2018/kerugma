package com.kerugma.infrastructure.persistence.entities;

import com.kerugma.infrastructure.persistence.entities.enums.InventoryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "shifts")
public class ShiftEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date", nullable = false)
  private LocalDate date;


  @Column(name = "time", nullable = false)
  private LocalTime time;

  @NotBlank(message = "El campo 'status' no debe estar vacío.")
  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "observations")
  private String observations;

  @Column(name = "placements")
  private Integer placements;

  @NotNull(message = "El campo 'type' no debe ser nulo.")
  @Enumerated(EnumType.STRING)
  @Column(name = "type", nullable = false)
  private InventoryType type;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "point_id", nullable = false)
  private PointEntity point;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;


}
