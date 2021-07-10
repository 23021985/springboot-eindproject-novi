package com.novi.eindproject.idrunk.version.july.repository;

import com.novi.eindproject.idrunk.version.july.model.Tafel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TafelRepository extends JpaRepository <Tafel, Long>{

//    Tafel getById(long id);

//    List<Tafel> findByNameContainingIgnoreCase(String query);

    Optional<Tafel> findById(Long id);
}
