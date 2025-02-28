package com.example.Library.Management.System.services.impl;
import com.example.Library.Management.System.dto.PublisherDTO;
import com.example.Library.Management.System.dto.PublisherSaveDTO;
import com.example.Library.Management.System.dto.PublisherUpdateDTO;
import com.example.Library.Management.System.entity.Publisher;
import com.example.Library.Management.System.repo.PublisherRepo;
import com.example.Library.Management.System.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;


    @Override
    public List<PublisherDTO> getAllPublishers() {
        List<Publisher> getAllPublishers = publisherRepo.findAll();
        List<PublisherDTO> publisherDTOS = new ArrayList<>();
        for (Publisher publisher : getAllPublishers) {
            PublisherDTO publisherDTO = new  PublisherDTO(
                    publisher.getPublisherId(),
                    publisher.getName()
            );
            publisherDTOS.add(publisherDTO);
        }
        return publisherDTOS;
    }

    @Override
    public String addPublisher(PublisherSaveDTO publisherSaveDTO) {
        Publisher publisher = new Publisher(
                publisherSaveDTO.getName()
        );
        publisherRepo.save(publisher);
        return "Add publisher Success";
    }

    @Override
    public String updatePublisher(PublisherUpdateDTO publisherUpdateDTO) {
        if(publisherRepo.existsById(publisherUpdateDTO.getPublisherId())) {
            Publisher publisher = publisherRepo.getById(publisherUpdateDTO.getPublisherId());
            publisher.setName(publisherUpdateDTO.getName());
            publisherRepo.save(publisher);
            return "Update publisher Success : " + publisher.getName();
        }
        else {
            return "Update publisher Fail publisher not found" ;
        }
    }

    @Override
    public String deletePublisher(int id) {
        if (publisherRepo.existsById(id)) {
            publisherRepo.deleteById(id);
        }
        else
        {
            return "Delete publisher Fail";
        }
        return "can,t delete publisher success";
    }
}
