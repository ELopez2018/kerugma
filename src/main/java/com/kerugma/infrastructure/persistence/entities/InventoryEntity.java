package com.kerugma.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kerugma.infrastructure.persistence.entities.enums.InventoryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "inventories")
public class InventoryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "El campo 'title' no debe estar vacío.")
  @Column(name = "title", nullable = false)
  private String title;

  @NotNull
  @Column(name = "stock", nullable = false)
  private Integer stock;

  @NotNull(message = "El campo 'type' no debe estar vacío.")
  @Enumerated(EnumType.STRING)
  @Column(name = "type", nullable = false)
  private InventoryType type;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @OneToOne
  @JsonBackReference
  @JoinColumn(name = "stand_id", nullable = false, unique = true)
  private StandEntity stand;

  @PrePersist
  @PreUpdate
  public void updateTimestamp() {
    this.updatedAt = LocalDateTime.now();
  }
}
