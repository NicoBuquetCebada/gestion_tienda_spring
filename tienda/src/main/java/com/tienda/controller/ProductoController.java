package com.tienda.controller;

import com.tienda.exception.CustomException;
import com.tienda.exception.CustomNotFoundException;
import com.tienda.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.tienda.model.Producto;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<Producto> findById(@PathVariable Integer id) throws CustomNotFoundException {
        return ResponseEntity.ok(productoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Producto> save(@Validated @RequestBody Producto producto) throws CustomException {
        return ResponseEntity.ok(productoService.save(producto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws CustomNotFoundException {
        productoService.delete(id);
    }

    @PutMapping
    public ResponseEntity<Producto> update(@Validated @RequestBody Producto producto) throws CustomNotFoundException {
        return ResponseEntity.ok(productoService.update(producto));
    }


}
