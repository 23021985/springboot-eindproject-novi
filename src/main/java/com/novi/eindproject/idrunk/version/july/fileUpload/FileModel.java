package com.novi.eindproject.idrunk.version.july.fileUpload;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "files")
public class FileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "media_type")
    private String mediaType;

    @Column(name = "location")
    private String location;

    @Column(name = "uploaded_timestamp")
    private Date uploadedTimestamp;

    @Column(name = "uploaded_by_username")
    private String uploadedByUsername;

}
