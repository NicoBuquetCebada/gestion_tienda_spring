package com.tienda.service;

import com.tienda.exception.CustomException;
import com.tienda.exception.CustomNotFoundException;
import com.tienda.model.Producto;
import com.tienda.repository.IProductoRepository;
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

    public Producto findById(Integer id) throws CustomNotFoundException {
        Optional <Producto> opt = productoRepository.findById(id);
        if (opt.isEmpty()) {
            throw new CustomNotFoundException("Producto no encontrado");
        }
        return opt.get();
    }

    public Producto save(Producto producto) throws CustomException {
        if (findByNombre(producto.getNombre()).isPresent()) {
            throw new CustomException("El producto ya existe");
        } else if (producto.getPrecio().compareTo(BigDecimal.valueOf(10)) < 0) {
            producto.setDescripcion(producto.getDescripcion() + " - producto de oferta");
        } else if (producto.getPrecio().compareTo(BigDecimal.valueOf(200)) > 0) {
            producto.setDescripcion(producto.getDescripcion() + " - producto de calidad");
        }
        return productoRepository.save(producto);
    }

    public void delete(Integer id) throws CustomNotFoundException {
        Producto producto = findById(id);
        productoRepository.delete(producto);
    }

    public Producto update(Producto producto) throws CustomNotFoundException {
        findById(producto.getId());
        return productoRepository.save(producto);
    }

    public Optional<Producto> findByNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

}
