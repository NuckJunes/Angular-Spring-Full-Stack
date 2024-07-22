package com.greenteam.FullStackApplication.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRequestDto {
    private CredentialDto credentials;

    private ProfileDto profile;

    private boolean admin;
}
