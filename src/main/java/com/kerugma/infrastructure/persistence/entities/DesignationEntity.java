package com.kerugma.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "designations")
public class DesignationEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @Column(name = "description")
  private String description;

  @JsonBackReference
  @ManyToMany(mappedBy = "designations", fetch = FetchType.EAGER)
  private List<UserEntity> users ;

  public DesignationEntity(Long id, String description) {
    this.id = id;
    this.description = description;
  }
  public DesignationEntity(String description) {
    this.description = description;
  }
}
