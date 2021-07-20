package com.novi.eindproject.idrunk.version.july.repository;
import com.novi.eindproject.idrunk.version.july.model.Tafel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TafelRepository extends JpaRepository <Tafel, Long>{

    Tafel getById(Long id);

//    List<Tafel> findByTafelNrContainingIgnoreCase(String query);

    void deleteById(long id);

//    Optional<User> findById(Long tafelId);

}
