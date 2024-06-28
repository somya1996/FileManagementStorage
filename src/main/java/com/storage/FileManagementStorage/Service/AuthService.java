package com.storage.FileManagementStorage.Service;

import com.storage.FileManagementStorage.dtos.LoginDto;
import com.storage.FileManagementStorage.dtos.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
