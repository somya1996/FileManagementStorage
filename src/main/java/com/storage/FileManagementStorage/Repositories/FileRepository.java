package com.storage.FileManagementStorage.Repositories;

import com.storage.FileManagementStorage.model.File;
import com.storage.FileManagementStorage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    List<File> findByUser(User user);
}
