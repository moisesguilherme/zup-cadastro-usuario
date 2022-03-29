package com.zup.cadastro.dto;

import com.zup.cadastro.services.validation.UserInsertValid;

@UserInsertValid
public class UserInsertDTO extends UserDTO{
	private static final long serialVersionUID = 1L;
	
	UserInsertDTO(){
		super();
	}
}