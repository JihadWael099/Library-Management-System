package com.example.Library.Management.System.dto;

import com.example.Library.Management.System.entity.Auther;
import com.example.Library.Management.System.entity.Publisher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {


    private int bookID;
    private String title;
    private Auther auther;
    private Publisher publisher;
}
