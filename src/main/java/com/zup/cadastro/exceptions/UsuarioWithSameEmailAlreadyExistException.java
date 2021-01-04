package com.zup.cadastro.exceptions;

public class UsuarioWithSameEmailAlreadyExistException extends RuntimeException {


    public UsuarioWithSameEmailAlreadyExistException(String s) {
        super(s);
    }
}
