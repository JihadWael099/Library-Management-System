package com.example.Library.Management.System.services;

import com.example.Library.Management.System.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    String addUser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUsers();

    String updateUser(UserUpdateDto userUpdateDTO);

    String deleteUser(int id);
}
