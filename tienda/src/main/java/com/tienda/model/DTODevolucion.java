package com.tienda.model;

import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

public class DTODevolucion {
    @NotNull(message = "el campo no puede ser nulo")
    private Integer compraId;

    @ColumnDefault("1")
    private Integer cantidad;

    public DTODevolucion(Integer compraId, Integer cantidad) {
        setCompraId(compraId);
        setCantidad(cantidad);
    }

    public Integer getCompraId() {
        return compraId;
    }

    public void setCompraId(Integer compraId) {
        this.compraId = compraId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
