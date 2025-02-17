package com.tienda.controller;

import com.tienda.exception.CustomException;
import com.tienda.model.DTOLogin;
import com.tienda.model.DTOUsuario;
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

    public Usuario findById(Integer id) throws CustomException {
        Optional<Usuario> opt = usuarioRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new CustomException("Usuario no encontrado");
    }

    public Usuario save(Usuario usuario) throws CustomException {
        if (!String.valueOf(usuario.getTelefono()).matches("^[69][0-9]{8}$")) {
            throw new CustomException("Formato del número de teléfono incorrecto");
        }
        if (findByNickname(usuario.getNickname()).isEmpty()) {
            return usuarioRepository.save(usuario);
        }
        throw new CustomException("El usuario ya existe");
    }

    public void delete(Integer id) throws CustomException {
        Usuario usuario = findById(id);
        usuarioRepository.delete(usuario);
    }

    public Usuario update(Usuario usuario) throws CustomException {
        findById(usuario.getId());
        return usuarioRepository.save(usuario);
    }

    public DTOUsuario login(DTOLogin login) throws CustomException {
        if (findByNickname(login.getNickname()).isEmpty()) {
            throw new CustomException("Nickname incorrecto");
        }
        Optional<Usuario> opt = usuarioRepository.findByNicknameAndPassword(login.getNickname(), login.getPassword());
        if (opt.isEmpty()) {
            throw new CustomException("Contraseña incorrecta");
        }
        return new DTOUsuario(opt.get());
    }

    public Optional<Usuario> findByNickname(String nickname) {
        return usuarioRepository.findByNickname(nickname);
    }
}
