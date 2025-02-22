package com.tienda.service;

import com.tienda.exception.CustomException;
import com.tienda.exception.CustomNotFoundException;
import com.tienda.exception.CustomUnauthorizedException;
import com.tienda.model.DTOLogin;
import com.tienda.model.DTOUsuario;
import com.tienda.model.Usuario;
import com.tienda.repository.IUsuarioRepository;
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

    public Usuario findById(Integer id) throws CustomNotFoundException {
        Optional<Usuario> opt = usuarioRepository.findById(id);
        if (opt.isEmpty()) {
            throw new CustomNotFoundException("Usuario no encontrado");
        }
        return opt.get();
    }

    public Usuario register(Usuario usuario) throws CustomException {
        if (findByNickname(usuario.getNickname()).isPresent()) {
            throw new CustomException("El usuario ya existe");
        }
        return usuarioRepository.save(usuario);
    }

    public void delete(Integer id) throws CustomNotFoundException {
        Usuario usuario = findById(id);
        usuarioRepository.delete(usuario);
    }

    public Usuario update(Usuario usuario) throws CustomNotFoundException {
        findById(usuario.getId());
        return usuarioRepository.save(usuario);
    }

    public DTOUsuario login(DTOLogin login) throws CustomUnauthorizedException {
        String nick = login.getNickname();
        String pass = login.getPassword();
        if (findByNickname(nick).isEmpty()) {
            throw new CustomUnauthorizedException("Nickname incorrecto");
        }
        Optional<Usuario> opt = usuarioRepository.findByNicknameAndPassword(nick, pass);
        if (opt.isEmpty()) {
            throw new CustomUnauthorizedException("Contraseña incorrecta");
        }
        return new DTOUsuario(opt.get());
    }

    public Optional<Usuario> findByNickname(String nickname) {
        return usuarioRepository.findByNickname(nickname);
    }
}
