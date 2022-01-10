package com.zup.cadastro.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zup.cadastro.dto.UserDTO;
import com.zup.cadastro.entities.User;
import com.zup.cadastro.repositories.UserRepository;
import com.zup.cadastro.services.exceptions.ResourceNotFoundException;

@Service
public class UserService{

    @Autowired
    private UserRepository repository;

    
    @Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));		
		return new UserDTO(entity);
	}
    
    public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
}
