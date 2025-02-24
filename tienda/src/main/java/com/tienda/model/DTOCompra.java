package com.tienda.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

public class DTOCompra {
    @NotNull(message = "el campo no puede ser nulo")
    private Integer usuarioId;

    @NotNull(message = "el campo no puede ser nulo")
    private Integer productoId;

    @ColumnDefault("1")
    private Integer cantidad;

    @Size(max = 200)
    private String descripcion;

    public DTOCompra(Integer usuarioId, Integer productoId, Integer cantidad, String descripcion) {
        setUsuarioId(usuarioId);
        setProductoId(productoId);
        if (cantidad < 1) {cantidad = 1;}
        setCantidad(cantidad);
        setDescripcion(descripcion);
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
