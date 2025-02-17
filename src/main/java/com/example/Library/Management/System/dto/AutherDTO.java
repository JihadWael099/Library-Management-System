package com.example.Library.Management.System.dto;

import jakarta.persistence.Column;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutherDTO {

    private int autherId;
    private String name;
}
