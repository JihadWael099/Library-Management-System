package com.example.Library.Management.System.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutherUpdateDTO {
    private int autherId;
    private String name;
}
