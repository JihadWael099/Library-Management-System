package com.example.Library.Management.System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSaveDTO {

    private String username;
    private String email;
    private String password;
}
