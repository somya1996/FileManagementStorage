package com.storage.FileManagementStorage.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FileAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public FileAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public FileAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
}
