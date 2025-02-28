package com.example.Library.Management.System.dto;

import com.example.Library.Management.System.entity.Auther;
import com.example.Library.Management.System.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookSaveDTO {

    private String title;
    private int auther_id;
    private int publisher_id;

    public BookSaveDTO(String title) {
        this.title = title;
    }
}
