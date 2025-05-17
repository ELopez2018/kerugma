package com.kerugma.adapters.in.rest;

import com.kerugma.application.services.UserService;
import com.kerugma.infrastructure.persistence.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserRestController {

  @Autowired
  private UserService userService;

  // Obtener todos los usuarios
  @GetMapping
  public List<UserEntity> getAllUsers() {
    return userService.getAllUsers();
  }

  // Obtener un usuario por ID
  @GetMapping("/{id}")
  public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
    Optional<UserEntity> user = userService.getUserById(id);
    return user.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Crear un nuevo usuario
  @PostMapping
  public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
    UserEntity newUser = userService.createUser(user);
    return ResponseEntity.ok(newUser);
  }

  // Actualizar un usuario
  @PutMapping("/{id}")
  public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity userDetails) {
    UserEntity updatedUser = userService.updateUser(id, userDetails);
    return updatedUser != null ? ResponseEntity.ok(updatedUser)
            : ResponseEntity.notFound().build();
  }

  // Eliminar un usuario
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    return userService.deleteUser(id) ? ResponseEntity.noContent().build()
            : ResponseEntity.notFound().build();
  }
}