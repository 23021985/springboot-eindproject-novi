package com.novi.eindproject.idrunk.version.july.fileUpload;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/files")
@CrossOrigin
public class FileController {

    @Autowired
    FileService fileService;


    @GetMapping("/files")
    public ResponseEntity<Object> getFiles() {
        Iterable<FileModel> files = fileService.getFiles();
        return ResponseEntity.ok().body(files);
    }


    @GetMapping("/files/{id}")
    public ResponseEntity<Object> getFileInfo(@PathVariable Long id) {
        FileResponseDto response = fileService.getFileById(id);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/files/{id}/download")
    public ResponseEntity downloadFile(@PathVariable Long id) {
        Resource resource = fileService.downloadFile(id);
        String mediaType = "application/octet-stream";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mediaType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


    @PostMapping(value = "/files",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<Object> uploadFile(FileRequestDto FileDto) {
        long newId = fileService.uploadFile(FileDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }


    @DeleteMapping("/files/{id}")
    public ResponseEntity<Object> deleteFile(@PathVariable Long id) {
        fileService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }
}
