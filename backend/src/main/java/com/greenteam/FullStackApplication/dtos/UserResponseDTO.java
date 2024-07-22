package com.greenteam.FullStackApplication.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserResponseDTO {
    private String username, first, last, email, phone;

}
