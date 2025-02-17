package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.AutherDTO;
import com.example.Library.Management.System.dto.AutherSaveDTO;
import com.example.Library.Management.System.dto.AutherUpdateDTO;
import com.example.Library.Management.System.entity.Auther;
import com.example.Library.Management.System.services.AutherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class AutherController {

    @Autowired
    private AutherService autherService;

    @PostMapping(path = "/author")
    public String saveAuthor(@RequestBody AutherSaveDTO autherSaveDTO) {
        String autherName= autherService.addAuther(autherSaveDTO);
        return autherName;
    }
    @GetMapping(path = "/authors")
    public List<AutherDTO> allAuthors() {
       return autherService.getAllAuthors();
    }
    @PutMapping(path = "/author")
    public String updateAuthor(@RequestBody AutherUpdateDTO autherUpdateDTO) {
        String autherName = autherService.updateAuther(autherUpdateDTO);
        return autherName ;
    }

    @DeleteMapping(path = "/authors/{id}")
    public String DeleteAuthor(@PathVariable(value="id") int id) {
        String autherName = autherService.deleteAuther(id);
        return "deleted ";
    }
}
