package com.tienda.service;

import com.tienda.exception.CustomException;
import com.tienda.exception.CustomNotFoundException;
import com.tienda.model.*;
import com.tienda.repository.IHistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HistorialService {
    private final IHistorialRepository historialRepository;
    private final ProductoService productoService;
    private final UsuarioService usuarioService;

    @Autowired
    public HistorialService(IHistorialRepository historialRepository, ProductoService productoService, UsuarioService usuarioService) {
        this.historialRepository = historialRepository;
        this.productoService = productoService;
        this.usuarioService = usuarioService;
    }

    public List<Historial> findAll() {
        return historialRepository.findAll();
    }

    @Cacheable(cacheNames = "historial")
    public Historial findById(Integer id) throws CustomNotFoundException {
        Optional<Historial> opt =  historialRepository.findById(id);
        if (opt.isEmpty()) {
            throw new CustomNotFoundException("Entrada del historial no encontrada");
        }
        return opt.get();
    }

    public List<DTOHistorial> findCompraByUsuario(Integer usuarioId) throws CustomNotFoundException {
        Usuario usuario = usuarioService.findById(usuarioId);
        List<Historial> historial = historialRepository.findHistorialByUsuario(usuario);
        List<DTOHistorial> compras = new ArrayList<>();
        for (Historial entrada : historial) {
            if (entrada.getTipo().equals("COMPRA")) {
                compras.add(new DTOHistorial(entrada));
            }
        }
        return compras;
    }

    public List<DTOHistorial> findDevolucionByUsuario(Integer usuarioId) throws CustomNotFoundException {
        Usuario usuario = usuarioService.findById(usuarioId);
        List<Historial> historial = historialRepository.findHistorialByUsuario(usuario);
        List<DTOHistorial> devoluciones = new ArrayList<>();
        for (Historial entrada : historial) {
            if (entrada.getTipo().equals("DEVOLUCION")) {
                devoluciones.add(new DTOHistorial(entrada));
            }
        }
        return devoluciones;
    }

    public Historial comprar(DTOCompra compra) throws CustomNotFoundException, CustomException {
        Producto producto = productoService.findById(compra.getProductoId());
        Usuario usuario = usuarioService.findById(compra.getUsuarioId());
        if (producto.getStock() < compra.getCantidad()) {
            throw new CustomException("No hay suficiente stock");
        }
        Historial historial = new Historial();
        historial.setUsuario(usuario);
        historial.setProducto(producto);
        historial.setFechaCompra(LocalDate.now());
        historial.setCantidad(compra.getCantidad());
        historial.setTipo("COMPRA");
        historial.setDescripcion(compra.getDescripcion());
        productoService.updateStock(producto, compra.getCantidad() * -1);
        return historialRepository.save(historial);
    }

    public Historial devolver(DTODevolucion devolucion) throws CustomNotFoundException, CustomException {
        Historial compra = findById(devolucion.getCompraId());
        Producto producto = compra.getProducto();
        Usuario usuario = compra.getUsuario();
        if (compra.getTipo().equals("DEVOLUCION")) {
            throw new CustomException("El id especificado pertenece a una devolucion");
        } else if (ChronoUnit.DAYS.between(compra.getFechaCompra(), LocalDate.now()) > 30) {
            throw new CustomException("Han pasado mas de 30 dias desde la fecha de compra");
        } else if (compra.getCantidad() == 0) {
            throw new CustomException("Esta compra ya ha sido devuelta por completo");
        } else if (compra.getCantidad() < devolucion.getCantidad()) {
            throw new CustomException("La cantidad especificada es mayor a la cantidad restante de la compra");
        }
        Historial historial = new Historial();
        historial.setUsuario(usuario);
        historial.setProducto(producto);
        historial.setFechaCompra(LocalDate.now());
        historial.setCantidad(devolucion.getCantidad());
        historial.setTipo("DEVOLUCION");
        productoService.updateStock(producto, devolucion.getCantidad());
        updateCantidad(compra, devolucion.getCantidad());
        return historialRepository.save(historial);
    }

    @CacheEvict(cacheNames = "historial", key = "#id")
    public void delete(Integer id) throws CustomNotFoundException {
        Historial historial = findById(id);
        historialRepository.delete(historial);
    }

    @CachePut(cacheNames = "historial", key = "#historial.id")
    public Historial update(Historial historial) throws CustomNotFoundException {
        findById(historial.getId());
        return historialRepository.save(historial);
    }

    public void updateCantidad(Historial historial, Integer cantidad) {
        Integer cantidad_updated = historial.getCantidad() - cantidad;
        historial.setCantidad(cantidad_updated);
        historialRepository.save(historial);
    }
}
