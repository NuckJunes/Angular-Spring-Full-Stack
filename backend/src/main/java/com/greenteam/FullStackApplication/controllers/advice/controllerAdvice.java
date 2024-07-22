package com.greenteam.FullStackApplication.controllers.advice;
import com.greenteam.FullStackApplication.dtos.ErrorDto;
import com.greenteam.FullStackApplication.exceptions.BadRequestException;
import com.greenteam.FullStackApplication.exceptions.NotAuthorizedException;
import com.greenteam.FullStackApplication.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = { "com.greenteam.FullStackApplication.controllers" })
@ResponseBody
public class controllerAdvice {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleBadRequestException(BadRequestException badRequestException) {
        return new ErrorDto(badRequestException.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleNotFoundException(NotFoundException notFoundException) {
        return new ErrorDto(notFoundException.getMessage());
    }

    @ExceptionHandler(NotAuthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorDto handleNotAuthorizedException(NotAuthorizedException notAuthorizedException) {
        return new ErrorDto(notAuthorizedException.getMessage());
    }
}
