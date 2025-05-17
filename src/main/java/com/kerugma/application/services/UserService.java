package com.kerugma.application.services;

import com.kerugma.infrastructure.persistence.entities.DesignationEntity;
import com.kerugma.infrastructure.persistence.entities.UserEntity;
import com.kerugma.infrastructure.persistence.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<UserEntity> getUserById(Long id) {
    return userRepository.findById(id);
  }

  @Transactional
  public UserEntity createUser(UserEntity user) {
    return userRepository.save(user);
  }

  public UserEntity updateUser(Long id, UserEntity userDetails) {
    if (userRepository.existsById(id)) {
      userDetails.setId(id);
      return userRepository.save(userDetails);
    }
    return null;
  }

  public boolean deleteUser(Long id) {
    if (userRepository.existsById(id)) {
      userRepository.deleteById(id);
      return true;
    }
    return false;
  }
}