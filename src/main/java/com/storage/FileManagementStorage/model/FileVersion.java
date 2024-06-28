package com.storage.FileManagementStorage.model;

public class FileVersion {
    private String filename;
    private byte[] fileContent;
    private int version;

    public FileVersion(String filename, byte[] fileContent, int version) {
        this.filename = filename;
        this.fileContent = fileContent;
        this.version = version;
    }

    public String getFilename() {
        return filename;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public int getVersion() {
        return version;
    }
}