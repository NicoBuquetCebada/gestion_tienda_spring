package com.tienda.controller;

import com.tienda.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.tienda.model.Producto;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Integer id) throws CustomException {
        return ResponseEntity.ok(productoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Producto> save(@Validated @RequestBody Producto producto) throws CustomException {
        return ResponseEntity.ok(productoService.save(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws CustomException {
        productoService.delete(id);
        return ResponseEntity.ok("Producto eliminado");
    }

    @PutMapping
    public ResponseEntity<Producto> update(@Validated @RequestBody Producto producto) throws CustomException {
        return ResponseEntity.ok(productoService.update(producto));
    }


}
