package com.zup.cadastro.exceptions;

public class UsuarioWithSameCpfAlreadyExistException extends RuntimeException {


    public UsuarioWithSameCpfAlreadyExistException(String s) {
        super(s);
    }
}
