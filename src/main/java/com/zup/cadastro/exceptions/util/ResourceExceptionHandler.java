package com.zup.cadastro.exceptions.util;

import com.zup.cadastro.exceptions.UsuarioWithSameCpfAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(UsuarioWithSameCpfAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handlerCategoriaException(UsuarioWithSameCpfAlreadyExistException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(500l);
        error.setTitle("Já existe usuário comm esse CPF.");
        error.setUrl("http://erros.teste.com/500");
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}
