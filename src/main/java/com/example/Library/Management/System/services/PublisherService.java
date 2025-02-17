package com.example.Library.Management.System.services;


import com.example.Library.Management.System.dto.PublisherDTO;
import com.example.Library.Management.System.dto.PublisherSaveDTO;
import com.example.Library.Management.System.dto.PublisherUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublisherService {
    List<PublisherDTO> getAllPublishers() ;
    String addPublisher(PublisherSaveDTO publisherSaveDTO);
    String updatePublisher(PublisherUpdateDTO publisherUpdateDTO);
    String deletePublisher(int id);
}
