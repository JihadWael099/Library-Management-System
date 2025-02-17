package com.example.Library.Management.System.services.impl;

import com.example.Library.Management.System.dto.AutherDTO;
import com.example.Library.Management.System.dto.AutherSaveDTO;
import com.example.Library.Management.System.dto.AutherUpdateDTO;
import com.example.Library.Management.System.entity.Auther;
import com.example.Library.Management.System.repo.AuthRepo;
import com.example.Library.Management.System.services.AutherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutherServiceImpl implements AutherService {


    @Autowired
     private AuthRepo authRepo;


    @Override
    public String addAuther(AutherSaveDTO autherSaveDTO) {
        Auther auther = new Auther(
                autherSaveDTO.getName()
        );

        authRepo.save(auther);
        return "Add Author Success";
    }

    @Override
    public List<AutherDTO> getAllAuthors() {
        List<Auther> getAllAuthers = authRepo.findAll();
        List<AutherDTO> autherDTOs = new ArrayList<>();
        for (Auther auther : getAllAuthers) {
            AutherDTO autherDTO = new AutherDTO(
                  auther.getAutherId(),
                  auther.getName()
            );
            autherDTOs.add(autherDTO);
        }

        return autherDTOs;

    }

    @Override
    public String updateAuther(AutherUpdateDTO autherUpdateDTO) {
        if(authRepo.existsById(autherUpdateDTO.getAutherId())) {
            Auther auther = authRepo.getById(autherUpdateDTO.getAutherId());
            auther.setName(autherUpdateDTO.getName());
            authRepo.save(auther);
            return "Update Author Success" + auther.getName();
        }
        else {
            return "Update Author Fail Author not found" ;
        }

    }

    @Override
    public String deleteAuther(int id) {
        if (authRepo.existsById(id)) {
            authRepo.deleteById(id);
        }
        else
        {
            return "Delete Author Fail";
        }
        return null;
    }


}
