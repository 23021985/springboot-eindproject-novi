package com.novi.eindproject.idrunk.version.july.repository;

import com.novi.eindproject.idrunk.version.july.model.Tafel;
import com.novi.eindproject.idrunk.version.july.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TafelRepository extends JpaRepository <Tafel, Long>{

    Tafel getById(Long id);

//    List<Tafel> findByTafelNrContainingIgnoreCase(String query);


    void deleteById(long id);

//    Optional<User> findById(Long tafelId);

}
