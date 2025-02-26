package com.tienda.repository;

import com.tienda.model.Historial;
import com.tienda.model.Usuario;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistorialRepository extends JpaRepository<Historial, Integer> {
    List<Historial> findHistorialByUsuario(Usuario usuario);
}
