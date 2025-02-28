package com.example.Library.Management.System.services.impl;

import com.example.Library.Management.System.dto.BorrowDTO;
import com.example.Library.Management.System.dto.BorrowSaveDTO;
import com.example.Library.Management.System.services.BorrowService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Override
    public String add(BorrowSaveDTO borrowSaveDTO) {
        return "";
    }

    @Override
    public List<BorrowDTO> getAll() {
        return List.of();
    }
}
