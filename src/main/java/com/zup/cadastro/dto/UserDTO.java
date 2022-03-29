package com.zup.cadastro.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.zup.cadastro.entities.User;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Nome é um campo obrigatório")
	private String name;

	@NotBlank(message = "Email é um campo obrigatório")
	private String email;

	@NotBlank(message = "CPF é um campo obrigatório")
	private String cpf;

    @Past(message = "A data de nascimento deve ser uma data passada")
    private Date birthDate;
    
    public UserDTO() {
    	
    }

	public UserDTO(Long id, String name, String email, String cpf, Date birthDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}
		
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
		this.birthDate = entity.getBirthDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
    
}
