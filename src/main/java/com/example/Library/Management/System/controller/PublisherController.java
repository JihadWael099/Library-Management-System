package com.example.Library.Management.System.controller;


import com.example.Library.Management.System.dto.*;
import com.example.Library.Management.System.services.AutherService;
import com.example.Library.Management.System.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class PublisherController {


    @Autowired
    private PublisherService publisherService;

    @PostMapping(path = "/publisher")
    public String savePublisher(@RequestBody PublisherSaveDTO publisherSaveDTO) {
        return publisherService.addPublisher( publisherSaveDTO);
    }
    @GetMapping(path = "/publishers")
    public List<PublisherDTO> allPublishers() {
        return publisherService.getAllPublishers();
    }
    @PutMapping(path = "/publisher")
    public String updateAuthor(@RequestBody PublisherUpdateDTO publisherUpdateDTO) {
        return publisherService.updatePublisher(publisherUpdateDTO);
    }

    @DeleteMapping(path = "/publishers/{id}")
    public String DeleteAuthor(@PathVariable(value="id") int id) {
        String publisherName = publisherService.deletePublisher(id);
        return "deleted";
    }





}
