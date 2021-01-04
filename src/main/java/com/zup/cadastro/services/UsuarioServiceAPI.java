package com.zup.cadastro.services;

import com.zup.cadastro.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioServiceAPI {
    public Usuario get(Long id);

    public List<Usuario> findAll();

    public Usuario create(Usuario usuario);

    public void update(Usuario usuario);

    public void remove(Long id);
}
