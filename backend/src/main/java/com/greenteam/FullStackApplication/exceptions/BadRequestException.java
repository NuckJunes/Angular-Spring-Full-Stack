package com.greenteam.FullStackApplication.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BadRequestException extends RuntimeException{
    @Serial
    private static final long serialVersionUID= -7241624271020971437L;

    private String message;
}
