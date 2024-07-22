package com.greenteam.FullStackApplication.dtos;

import com.greenteam.FullStackApplication.entities.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserResponseDTO {
    private Profile profile; // Should this be a ProfileDto???
    private String username;

}
