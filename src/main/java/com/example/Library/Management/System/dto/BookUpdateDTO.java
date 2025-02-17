package com.example.Library.Management.System.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookUpdateDTO {

    private int bookID;
    private String title;
    private int auther_id;
    private int publisher_id;
}
