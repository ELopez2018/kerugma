package com.kerugma.infrastructure.configuration.init;


import com.kerugma.infrastructure.persistence.entities.DesignationEntity;
import com.kerugma.infrastructure.persistence.repositories.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

  @Autowired
  private DesignationRepository designationRepository;


  @Override
  public void run(String... args) throws Exception {
//    if (designationRepository.count() == 0) {
//        designationRepository.saveAll(Arrays.asList(
//                new DesignationEntity(1L, "Publicador"),
//                new DesignationEntity(2L, "Precursor Auxiliar"),
//                new DesignationEntity(3L, "Precursor Regular"),
//                new DesignationEntity(4L, "Precursor Especial"),
//                new DesignationEntity(5L, "Siervo Ministerial"),
//                new DesignationEntity(6L, "Anciano")
//
//      ));
//    }
  }
}