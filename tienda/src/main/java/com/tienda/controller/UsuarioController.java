package com.tienda.controller;

import com.tienda.exception.CustomException;
import com.tienda.exception.CustomNotFoundException;
import com.tienda.exception.CustomUnauthorizedException;
import com.tienda.model.DTOLogin;
import com.tienda.model.DTOUsuario;
import com.tienda.model.Usuario;
import com.tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) throws CustomNotFoundException {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> register(@Validated @RequestBody Usuario usuario) throws CustomException {
        return ResponseEntity.ok(usuarioService.register(usuario));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws CustomNotFoundException {
        usuarioService.delete(id);
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@Validated @RequestBody Usuario usuario) throws CustomNotFoundException {
        return ResponseEntity.ok(usuarioService.update(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<DTOUsuario> login(@RequestBody DTOLogin login) throws CustomUnauthorizedException {
        return ResponseEntity.ok(usuarioService.login(login));
    }
}
