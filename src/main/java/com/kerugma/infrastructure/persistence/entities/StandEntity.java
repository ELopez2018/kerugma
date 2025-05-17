package com.kerugma.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "stands")
public class StandEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @Column(name = "type", nullable = false)
  private String type;

  @NotBlank(message = "El campo 'status' no debe estar vacío.")
  @Column(name = "status", nullable = false)
  private String status;


  @Column(name = "observations", nullable = true)
  private String observations;

  @Column(name = "poster", nullable = true)
  private String poster;

  @ManyToOne(optional = false)
  @JoinColumn(name = "congregation_id", nullable = false)
  private CongregationEntity congregation;

  @JsonManagedReference
  @OneToOne(mappedBy = "stand", cascade = CascadeType.ALL, orphanRemoval = true)
  private InventoryEntity inventory;

  @JsonBackReference
  @ManyToOne(optional = false)
  @JoinColumn(name = "point_id", nullable = false)
  private PointEntity point;

}
