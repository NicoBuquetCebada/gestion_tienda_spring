package com.tienda.controller;

import com.tienda.exception.CustomException;
import com.tienda.exception.CustomNotFoundException;
import com.tienda.model.DTOCompra;
import com.tienda.model.DTODevolucion;
import com.tienda.model.DTOHistorial;
import com.tienda.model.Historial;
import com.tienda.service.HistorialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/historial")
public class HistorialController {
    private final HistorialService historialService;

    @Autowired
    public HistorialController(HistorialService historialService) {
        this.historialService = historialService;
    }

    @GetMapping
    public ResponseEntity<List<Historial>> findAll() {
        return ResponseEntity.ok(historialService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historial> findById(@PathVariable Integer id) throws CustomNotFoundException {
        return ResponseEntity.ok(historialService.findById(id));
    }

    @PostMapping("/compra")
    public ResponseEntity<Historial> comprar(@Valid @RequestBody DTOCompra compra) throws CustomNotFoundException, CustomException {
        return ResponseEntity.ok(historialService.comprar(compra));
    }

    @PostMapping("/devolucion")
    public ResponseEntity<Historial> devolver(@Valid @RequestBody DTODevolucion devolucion) throws CustomNotFoundException, CustomException {
        return ResponseEntity.ok(historialService.devolver(devolucion));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws CustomNotFoundException {
        historialService.delete(id);
    }

    @PutMapping
    public ResponseEntity<Historial> update(@RequestBody Historial historial) throws CustomNotFoundException {
        return ResponseEntity.ok(historialService.update(historial));
    }

    @GetMapping("/compras/{id}")
    public ResponseEntity<List<DTOHistorial>> getComprasByUsuario(@PathVariable Integer id) throws CustomNotFoundException {
        return ResponseEntity.ok(historialService.findCompraByUsuario(id));
    }

    @GetMapping("/devoluciones/{id}")
    public ResponseEntity<List<DTOHistorial>> getDevolucionesByUsuario(@PathVariable Integer id) throws CustomNotFoundException {
        return ResponseEntity.ok(historialService.findDevolucionByUsuario(id));
    }



}
