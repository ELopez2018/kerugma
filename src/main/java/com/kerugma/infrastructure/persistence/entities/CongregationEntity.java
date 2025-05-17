package com.kerugma.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "congregations")
public class CongregationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "El campo 'title' no debe estar vacío.")
  @Column(name = "name", nullable = false)
  private String name;

  @NotBlank(message = "El campo 'title' no debe estar vacío.")
  @Column(name = "number", nullable = false)
  private String number;

  @JsonManagedReference
  @OneToMany(mappedBy = "congregation", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<StandEntity> stands = new ArrayList<>();


}
