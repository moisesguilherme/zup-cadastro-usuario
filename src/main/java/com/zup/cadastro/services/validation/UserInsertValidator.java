package com.zup.cadastro.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.zup.cadastro.controllers.exceptions.FieldMessage;
import com.zup.cadastro.dto.UserInsertDTO;
import com.zup.cadastro.entities.User;
import com.zup.cadastro.repositories.UserRepository;

//UserInsertDTO vai receber a anotation UserInsertValid
public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {
	
	@Autowired
	private UserRepository repository;
		
	@Override
	public void initialize(UserInsertValid ann) {
	}

	@Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
		User user = repository.findByEmail(dto.getEmail());
		
		// Aproveita o ciclo de vida do Bean Validation
		if (user != null) {
			list.add(new FieldMessage("email", "Email já existe"));
		}
		
		// CPF válido
		/*Pattern cpfPattern = Pattern.compile("[A-F]{5,}.*");
		Matcher match = cpfPattern.matcher(user.getCpf());
		Boolean isMatch = match.matches();
		if (isMatch) {
			list.add(new FieldMessage("CPF", "O CPF é um formato inválido"));
		}*/
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}


