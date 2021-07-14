package com.novi.eindproject.idrunk.version.july.fileUpload;

import lombok.Data;

@Data
public class FileResponseDto {
    private String title;
    private String description;
    private String fileName;
    private String mediaType;
    private String downloadUri;
}
