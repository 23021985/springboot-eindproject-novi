package com.novi.eindproject.idrunk.version.july.repository;

import com.novi.eindproject.idrunk.version.july.model.Tafel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TafelRepository extends JpaRepository <Tafel, String>{

    Tafel getById(Long id);

//    List<Tafel> findByTafelNrContainingIgnoreCase(String query);


    void deleteById(long id);
}
