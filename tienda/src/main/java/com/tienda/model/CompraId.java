package com.tienda.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.time.Instant;
import java.util.Objects;

@Embeddable
public class CompraId implements java.io.Serializable {
    private static final long serialVersionUID = -4700620847950843228L;
    @NotNull
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @NotNull
    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @NotNull
    @Column(name = "fecha_compra", nullable = false)
    private Instant fechaCompra;

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

    public Instant getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Instant fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompraId entity = (CompraId) o;
        return Objects.equals(this.fechaCompra, entity.fechaCompra) &&
                Objects.equals(this.productoId, entity.productoId) &&
                Objects.equals(this.usuarioId, entity.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaCompra, productoId, usuarioId);
    }

}