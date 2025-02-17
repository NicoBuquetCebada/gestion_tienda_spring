package com.tienda.controller;

import com.tienda.model.Producto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
    Optional<Producto> findByNombre(@Size(max = 100) @NotNull @Pattern(regexp = "^[a-zA-Z0-9 ]{5,100}$") String nombre);
}
