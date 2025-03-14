package com.example.Library.Management.System.services;

import com.example.Library.Management.System.dto.*;

import java.util.List;

public interface BorrowService {

    String add(BorrowSaveDTO borrowSaveDTO);

    List<BorrowDTO> getAll();
    String updateBorrow(BorrowUpdateDTO borrowUpdateDTO);
}
