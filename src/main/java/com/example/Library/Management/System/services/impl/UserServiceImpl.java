package com.example.Library.Management.System.services.impl;

import com.example.Library.Management.System.dto.PublisherDTO;
import com.example.Library.Management.System.dto.UserDTO;
import com.example.Library.Management.System.dto.UserSaveDTO;
import com.example.Library.Management.System.dto.UserUpdateDto;
import com.example.Library.Management.System.entity.Auther;
import com.example.Library.Management.System.entity.Publisher;
import com.example.Library.Management.System.entity.User;
import com.example.Library.Management.System.repo.UserRepo;
import com.example.Library.Management.System.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;


    @Override
    public String addUser(UserSaveDTO userSaveDTO) {
        User user = new User(
                userSaveDTO.getUsername(),
                userSaveDTO.getEmail(),
                userSaveDTO.getPassword()
        );
        userRepo.save(user);
        return "Add user Success";
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> getAllUsers = userRepo.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : getAllUsers) {
            UserDTO userDTO = new  UserDTO(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword()
            );
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public String updateUser(UserUpdateDto userUpdateDTO) {
        if(userRepo.existsById(userUpdateDTO.getId())) {
            User user = userRepo.getById(userUpdateDTO.getId());
            user.setUsername(userUpdateDTO.getUsername());
            user.setEmail(userUpdateDTO.getEmail());
            user.setPassword(userUpdateDTO.getPassword());
            userRepo.save(user);
            return "Update user Success : " + userUpdateDTO.getUsername();
        }
        else {
            return "Update user Fail publisher not found" ;
        }
    }

    @Override
    public String deleteUser(int id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        }
        else
        {
            return "Delete user Fail";
        }
        return "can,t delete user success";
    }
}
