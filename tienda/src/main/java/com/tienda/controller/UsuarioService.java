package com.tienda.controller;

import com.tienda.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> save(Usuario usuario) {
        Optional<Usuario> opt = findById(usuario.getId());
        if (opt.isEmpty()) {
            usuarioRepository.save(usuario);
        }
        return opt;
    }

    public boolean delete(Integer id) {
        Optional<Usuario> opt = findById(id);
        if (opt.isPresent()) {
            usuarioRepository.delete(opt.get());
            return true;
        }
        return false;
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findByNicknameAndPassword(String nickname, String password) {
        return usuarioRepository.findByNicknameAndPassword(nickname, password);
    }

    public Optional<Usuario> findByNickname(String nickname) {
        return usuarioRepository.findByNickname(nickname);
    }
}
