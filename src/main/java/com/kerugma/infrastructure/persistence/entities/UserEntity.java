package com.kerugma.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  protected Long id;

  @Column(name = "fullName")
  private String fullName;

  @Column(name = "image")
  private String image;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "secondName")
  private String secondName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "surname")
  private String surname;

  @Column(name = "birthdate")
  private LocalDate birthdate;

  @Column(name = "gender")
  private String gender;

  @Column(name = "document_number", unique = true)
  private Long documentNumber;

  @Column(name = "document_type")
  private String documentType;

  @Column(name = "cellPhone")
  private String cellPhone;

  @Column(name = "phone")
  private String phone;

  @Column(name = "approved")
  private LocalTime approved;

  @Column(name = "email", unique = true)
  private String email;

  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
  @JoinTable(name = "user_designations",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "designation_id"))
  private Set<DesignationEntity> designations = new HashSet<>();



}