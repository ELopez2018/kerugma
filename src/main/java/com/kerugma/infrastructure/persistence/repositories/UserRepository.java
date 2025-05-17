package com.kerugma.infrastructure.persistence.repositories;

import com.kerugma.infrastructure.persistence.entities.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByEmail(String email);
  UserEntity findByDocumentNumber(Long documentNumber);
}