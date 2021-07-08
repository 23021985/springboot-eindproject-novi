package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.model.Tafel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.table.TableModel;
import java.util.List;


@Repository
public interface FetchDataService extends JpaRepository<Tafel, Integer> {

    @Override
    List<Tafel>findAll();
}
