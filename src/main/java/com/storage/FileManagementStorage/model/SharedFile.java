package com.storage.FileManagementStorage.model;

import java.util.List;

public class SharedFile {
    private String filename;
    private List<String> sharedUsers;

    public SharedFile(String filename, List<String> sharedUsers) {
        this.filename = filename;
        this.sharedUsers = sharedUsers;
    }

    public String getFilename() {
        return filename;
    }

    public List<String> getSharedUsers() {
        return sharedUsers;
    }
}