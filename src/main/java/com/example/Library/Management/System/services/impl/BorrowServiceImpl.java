package com.example.Library.Management.System.services.impl;

import com.example.Library.Management.System.dto.BorrowDTO;
import com.example.Library.Management.System.dto.BorrowSaveDTO;
import com.example.Library.Management.System.dto.BorrowUpdateDTO;
import com.example.Library.Management.System.entity.Borrow;
import com.example.Library.Management.System.repo.BookRepo;
import com.example.Library.Management.System.repo.BorrowRepo;
import com.example.Library.Management.System.repo.UserRepo;
import com.example.Library.Management.System.services.BorrowService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {


    private final BookRepo bookRepo;
    private  final UserRepo userRepo;
    private final BorrowRepo borrowRepo;
    public BorrowServiceImpl(BookRepo bookRepo, UserRepo userRepo, BorrowRepo borrowRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
        this.borrowRepo = borrowRepo;
    }

    @Override
    public String add(BorrowSaveDTO borrowSaveDTO) {
        Borrow borrow = new Borrow(
                bookRepo.getById(borrowSaveDTO.getBook().getBookID()),
                userRepo.getById(borrowSaveDTO.getUser().getId()),
                borrowSaveDTO.getBorrowDate(),
                borrowSaveDTO.getReturnDate()
        );
        borrowRepo.save(borrow);
        return "add";
    }

    @Override
    public List<BorrowDTO> getAll() {
        List<Borrow> getBorrow = borrowRepo.findAll();
        List<BorrowDTO> borrowDTOList = new ArrayList<>();
        for(Borrow borrow : getBorrow)
        {
            BorrowDTO borrowDTO = new BorrowDTO(
                    borrow.getId(),
                    borrow.getBook(),
                    borrow.getUser(),
                    borrow.getBorrowDate(),
                    borrow.getReturnDate()
            );
            borrowDTOList.add(borrowDTO);
        }
        return borrowDTOList;
    }

    @Override
    public String updateBorrow(BorrowUpdateDTO borrowUpdateDTO) {
        try {
            if(borrowRepo.existsById(borrowUpdateDTO.getId())) {
                Borrow borrow = borrowRepo.getById(borrowUpdateDTO.getId());
                borrow.setBook(bookRepo.getById(borrowUpdateDTO.getBookid()));
                borrow.setUser(userRepo.getById(borrowUpdateDTO.getUserId()));
                borrow.setBorrowDate(borrowUpdateDTO.getBorrowDate());
                borrow.setReturnDate(borrowUpdateDTO.getReturnDate());
                borrowRepo.save(borrow);
                return "Borrow updated successfully.";
            }
            else
            {
                System.out.println("Borrow ID Not Found");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return null;
    }
}
