package com.kerugma.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "credentials")
public class CredentialEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username", unique = true, nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;
}
