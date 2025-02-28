package com.example.Library.Management.System.controller;


import com.example.Library.Management.System.dto.*;
import com.example.Library.Management.System.services.PublisherService;
import com.example.Library.Management.System.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/user")
    public String saveUser(@RequestBody UserSaveDTO userSaveDTO) {
        return userService.addUser( userSaveDTO);
    }


    @GetMapping(path = "/Users")
    public List<UserDTO> allUsers() {
        return userService.getAllUsers();
    }


    @PutMapping(path = "/user")
    public String updateAuthor(@RequestBody UserUpdateDto userUpdateDTO) {
        return userService.updateUser(userUpdateDTO);
    }

    @DeleteMapping(path = "/users/{id}")
    public String DeleteAuthor(@PathVariable(value="id") int id) {
        String userName = userService.deleteUser(id);
        return "deleted";
    }
}
