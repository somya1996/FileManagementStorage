package com.storage.FileManagementStorage.Service;

import com.storage.FileManagementStorage.Repositories.FileRepository;
import com.storage.FileManagementStorage.model.File;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public File saveAttachment(MultipartFile file) throws Exception {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                        + fileName);
            }

            File attachment
                    = new File(fileName,
                    file.getContentType(),
                    file.getBytes());
            return fileRepository.save(attachment);

        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }

    @Override
    public File getAttachment(String fileId) throws Exception {
        return fileRepository
                .findById(Long.valueOf(fileId))
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + fileId));
    }

    @Override
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
}