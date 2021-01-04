package com.zup.cadastro.resources;

import com.zup.cadastro.domain.Usuario;
import com.zup.cadastro.repositories.UsuarioRepository;
import com.zup.cadastro.services.UsuarioServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioServiceAPI service;
    //private UsuarioRepository repository;

    @GetMapping("/{id}")
    @ResponseBody
    HttpEntity<Object> get(@PathVariable(name = "id") Long id) {

        Usuario usuario = service.get(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    @ResponseBody HttpEntity<Object> findAll() {

        List<Usuario> usuarios = service.findAll();

        if(usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(usuarios);
    }


    @PostMapping
    @ResponseBody HttpEntity<Object> create(@RequestBody Usuario usuario){

        usuario = service.create(usuario);
        return ResponseEntity.ok(usuario);
    }


    @PutMapping("/{id}")
    @ResponseBody  HttpEntity<Object> update(@PathVariable(name = "id") Long id,
                                             @RequestBody Usuario usuario) {
        usuario.setId(id);
        service.update(usuario);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    @ResponseBody  HttpEntity<Object> remove(@PathVariable(name = "id") Long id) {

        service.remove(id);
        return ResponseEntity.noContent().build();
    }
    
}
