package com.kerugma.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "points")
public class PointEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "El campo 'title' no debe estar vacío.")
  @Column(name = "title", nullable = false)
  private String title;

  @NotBlank(message = "El campo 'state' no debe estar vacío.")
  @Column(name = "state", nullable = false)
  private String state;

  @NotBlank(message = "El campo 'municipality' no debe estar vacío.")
  @Column(name = "municipality", nullable = false)
  private String municipality;

  @NotBlank(message = "El campo 'city' no debe estar vacío.")
  @Column(name = "city", nullable = false)
  private String city;

  @NotBlank(message = "El campo 'neighborhood' no debe estar vacío.")
  @Column(name = "neighborhood", nullable = false)
  private String neighborhood;

  @NotBlank(message = "El campo 'benchmark' no debe estar vacío.")
  @Column(name = "benchmark", nullable = false)
  private String benchmark;

  @NotBlank(message = "El campo 'status' no debe estar vacío.")
  @Column(name = "status", nullable = false)
  private String status;

  @NotBlank(message = "El campo 'pictures' no debe estar vacío.")
  @Column(name = "pictures", nullable = false)
  private String pictures;

  @Column(precision = 9, scale = 6)
  private BigDecimal latitud;

  @Column(precision = 9, scale = 6)
  private BigDecimal longitud;


  @OneToMany(mappedBy = "point", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<StandEntity> stands = new ArrayList<>();

  @JsonBackReference
  @OneToMany(mappedBy = "point", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ShiftEntity> shifts = new ArrayList<>();

}
