package com.novi.eindproject.idrunk.version.july.fileUpload;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileRepository extends CrudRepository<FileModel, Long> {

//    CrudRepository
    //Misschien toch JPA
}
