package com.storage.FileManagementStorage.Service;

import com.storage.FileManagementStorage.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    File saveAttachment(MultipartFile file) throws Exception;

    File getAttachment(String fileId) throws Exception;

    List<File> getAllFiles();
}