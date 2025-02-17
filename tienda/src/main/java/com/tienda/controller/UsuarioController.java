package com.tienda.controller;

import com.tienda.exception.CustomException;
import com.tienda.model.DTOLogin;
import com.tienda.model.DTOUsuario;
import com.tienda.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) throws CustomException {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@Validated @RequestBody Usuario usuario) throws CustomException {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws CustomException {
        usuarioService.delete(id);
        return ResponseEntity.ok("Usuario eliminado");
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@Validated @RequestBody Usuario usuario) throws CustomException {
        return ResponseEntity.ok(usuarioService.update(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<DTOUsuario> login(@Validated @RequestBody DTOLogin login) throws CustomException {
        return ResponseEntity.ok(usuarioService.login(login));
    }
}
