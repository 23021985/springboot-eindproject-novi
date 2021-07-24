package com.novi.eindproject.idrunk.version.july.fileUpload;

import org.springframework.core.io.Resource;

public interface FileService {

    void init();
    Iterable<FileModel> getFiles();
    FileResponseDto getFileById(long id);
    boolean fileExistsById(long id);
    long uploadFile(FileRequestDto fileDto);
    void deleteFile(long id);
    Resource downloadFile(long id);

}
