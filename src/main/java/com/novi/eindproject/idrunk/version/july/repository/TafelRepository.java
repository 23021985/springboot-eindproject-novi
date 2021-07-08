package com.novi.eindproject.idrunk.version.july.repository;

import com.novi.eindproject.idrunk.version.july.model.Tafel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.table.TableModel;
import java.util.List;

public interface TafelRepository extends JpaRepository <Tafel, Long>{

    Tafel getById(long id);
//
//    List<Tafel> findByNameContainingIgnoreCase(String query);
//
//    List<Tafel> findByType(String type);
}
