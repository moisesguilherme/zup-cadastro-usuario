package com.zup.cadastro.services;

import com.zup.cadastro.domain.Usuario;
import com.zup.cadastro.exceptions.UsuarioWithSameCpfAlreadyExistException;
import com.zup.cadastro.exceptions.UsuarioWithSameEmailAlreadyExistException;
import com.zup.cadastro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService implements UsuarioServiceAPI{

    @Autowired
    private UsuarioRepository repositoryJPA;

    @Override
    @Transactional(readOnly = true)
    public Usuario get(Long id) {
        Usuario usuario = repositoryJPA.findById(id).get();
        return usuario;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        List<Usuario> usuario = repositoryJPA.findAll();
        return usuario;
    }

    @Override
    @Transactional
    public Usuario create(Usuario usuario) {
        Usuario usuarioBuscado = repositoryJPA.findByCpf(usuario.getCPF());
        if(usuarioBuscado != null) {
            throw new UsuarioWithSameCpfAlreadyExistException("Não é possível registrar dois clientes com o mesmo cpf!");
        }
        usuarioBuscado = repositoryJPA.findByEmail(usuario.getEmail());

        if(usuarioBuscado != null) {
            throw new UsuarioWithSameEmailAlreadyExistException("Não é possível com o mesmo email!");
        }

        return repositoryJPA.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public void remove(Long id) {

    }
}
