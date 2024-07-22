package com.greenteam.FullStackApplication.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NotAuthorizedException extends RuntimeException{
    @Serial
    private static final long serialVersionUID= 5906969915045458651L;

    private String message;
}
