package com.storage.FileManagementStorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileUploadDownload {
    private String uploadDir;

    public FileUploadDownload(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    public void uploadFile(String filename, byte[] fileContent) {
        File file = new File(uploadDir + "/" + filename);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] downloadFile(String filename) {
        File file = new File(uploadDir + "/" + filename);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileContent = new byte[(int) file.length()];
            fis.read(fileContent);
            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}