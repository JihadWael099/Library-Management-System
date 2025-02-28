package com.example.Library.Management.System.dto;

import com.example.Library.Management.System.entity.Book;
import com.example.Library.Management.System.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowSaveDTO {




    private Book book;

    private User user;

    private LocalDate borrowDate;
    private LocalDate returnDate;
}
