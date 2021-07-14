package com.novi.eindproject.idrunk.version.july.fileUpload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileRequestDto {
    private String title;
    private String description;
    private MultipartFile file;
}
