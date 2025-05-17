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
    if (designationRepository.count() == 0) {
        designationRepository.saveAll(Arrays.asList(
                new DesignationEntity( "Publicador"),
                new DesignationEntity( "Precursor Auxiliar"),
                new DesignationEntity( "Precursor Regular"),
                new DesignationEntity( "Precursor Especial"),
                new DesignationEntity( "Siervo Ministerial"),
                new DesignationEntity( "Anciano")

      ));
    }
  }
}