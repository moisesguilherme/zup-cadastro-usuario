package com.zup.cadastro.repositories;

import com.zup.cadastro.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select usuario from Usuario usuario where usuario.cpf = ?1")
    public Usuario findByCpf(String cpf);

    @Query("select usuario from Usuario usuario where usuario.email = ?1")
    public Usuario findEmail(String email);
}
