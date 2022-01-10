package com.zup.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zup.cadastro.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
