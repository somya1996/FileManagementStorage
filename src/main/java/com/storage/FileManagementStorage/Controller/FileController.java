package com.storage.FileManagementStorage.Controller;

import com.storage.FileManagementStorage.Service.FileService;
import com.storage.FileManagementStorage.dtos.ResponseData;
import com.storage.FileManagementStorage.model.File;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService= fileService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        File attachment = null;
        String downloadURl = "";
        attachment = fileService.saveAttachment(file);
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();

        return new ResponseData(attachment.getFileName(),
                downloadURl,
                file.getContentType(),
                file.getSize());
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        File attachment = null;
        attachment = fileService.getAttachment(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getFileName()
                                + "\"")
                .body(new ByteArrayResource(attachment.getData()));
    }

    @GetMapping("allFiles")
    public List<ResponseData> getAllFiles() {
        List<File> files = fileService.getAllFiles();
        return files.stream()
                .map(file -> new ResponseData(file.getFileName(),
                        ServletUriComponentsBuilder.fromCurrentContextPath()
                                .path("/download/")
                                .path(file.getId())
                                .toUriString(),
                        file.getFileType(),
                        file.getData().length))
                .toList();
    }

}