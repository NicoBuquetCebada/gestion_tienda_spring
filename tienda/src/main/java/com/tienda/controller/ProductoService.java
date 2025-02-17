package com.tienda.controller;

import com.tienda.exception.CustomException;
import com.tienda.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final IProductoRepository productoRepository;

    @Autowired
    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findById(Integer id) throws CustomException {
        Optional <Producto> opt = productoRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new CustomException("Producto no encontrado");
    }

    public Producto save(Producto producto) throws CustomException {
        Optional<Producto> opt = productoRepository.findByNombre((producto.getNombre()));
        if (opt.isPresent()) {
            throw new CustomException("El producto ya existe");
        } else if (producto.getPrecio().compareTo(BigDecimal.valueOf(10)) == -1) {
            producto.setDescripcion(producto.getDescripcion() + " - producto de oferta");
        } else if (producto.getPrecio().compareTo(BigDecimal.valueOf(200)) == 1) {
            producto.setDescripcion(producto.getDescripcion() + " - producto de calidad");
        }
        return productoRepository.save(producto);
    }

    public void delete(Integer id) throws CustomException {
        Producto producto = findById(id);
        productoRepository.delete(producto);
    }

    public Producto update(Producto producto) throws CustomException {
        findById(producto.getId());
        return productoRepository.save(producto);
    }


}
