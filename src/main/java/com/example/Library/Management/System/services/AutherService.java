package com.example.Library.Management.System.services;


import com.example.Library.Management.System.dto.AutherDTO;
import com.example.Library.Management.System.dto.AutherSaveDTO;
import com.example.Library.Management.System.dto.AutherUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AutherService {
    String addAuther(AutherSaveDTO autherSaveDTO);
    List<AutherDTO> getAllAuthors();
    String updateAuther(AutherUpdateDTO autherUpdateDTO);
    String deleteAuther(int id);
}
