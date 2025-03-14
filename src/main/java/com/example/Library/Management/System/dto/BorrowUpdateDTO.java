package com.example.Library.Management.System.dto;


import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowUpdateDTO {

    private int id;
    private int bookid;
    private int userId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
