package com.example.Library.Management.System.controller;


import com.example.Library.Management.System.dto.BorrowDTO;
import com.example.Library.Management.System.dto.BorrowSaveDTO;
import com.example.Library.Management.System.dto.BorrowUpdateDTO;
import com.example.Library.Management.System.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping("/borrow")
    public String saveBorrow(@RequestBody BorrowSaveDTO borrowSaveDTO)
    {
        String borrowBooks = borrowService.add(borrowSaveDTO);
        return  "Borrowel Successfully";
    }
    @GetMapping(path = "/Borrows")
    public List<BorrowDTO> getAllBorrow()
    {
        List<BorrowDTO> allBorrow = borrowService.getAll();
        return allBorrow;
    }
    @PutMapping(path = "/borrow")
    public String updateBorrow(@RequestBody BorrowUpdateDTO borrowUpdateDTO)
    {
        String borrow = borrowService.updateBorrow(borrowUpdateDTO);
        return  "Updatedddd";
    }
}
