package com.tienda.controller;

import com.tienda.model.Usuario;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNicknameAndPassword(@Size(max = 50) @NotNull @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Error de formato")
                                                String nickname, @NotNull @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[.,+\\-!¡?¿])[A-Za-z0-9.,+\\-!¡?¿]{8,30}$", message = "Error de formato") String password);

    Optional<Usuario> findByNickname(@Size(max = 50) @NotNull @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Error de formato") String nickname);
}
