package co.com.pragma.api.controller;

import co.com.pragma.api.dto.ResponseErrorDto;
import co.com.pragma.api.mapper.ErrorResponseMapper;
import co.com.pragma.model.tournament.config.ErrorCode;
import co.com.pragma.model.tournament.config.ErrorDictionary;
import co.com.pragma.model.tournament.config.PragmaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class) //excepcion para validar parametros que llegan en la peticion, parametros obligatorios y longitudes, entre otros
    public ResponseEntity<ResponseErrorDto> handleConstraintViolationException(MethodArgumentNotValidException e) {
        return genericHandleException(ErrorCode.B400001);
    }

    @ExceptionHandler(PragmaException.class)
    public ResponseEntity<ResponseErrorDto> handlePragmaException(PragmaException e) {
        return genericHandleException(e.getError());
    }

    private ResponseEntity<ResponseErrorDto> genericHandleException(ErrorCode errorCode) {
        ErrorDictionary errorDictionary = ErrorDictionary.builder()
                .id(errorCode.getCode())
                .message(errorCode.getLog())
                .httpStatus(errorCode.getStatus())
                .build();

        ResponseErrorDto responseErrorDto = ErrorResponseMapper.toResponseErrorDto(errorDictionary);

        return ResponseEntity
                .status(Objects.requireNonNull(HttpStatus.resolve(errorDictionary.getHttpStatus())))
                .body(responseErrorDto);
    }

}
