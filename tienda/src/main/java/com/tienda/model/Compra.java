package com.tienda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "compras")
public class Compra {
    @EmbeddedId
    private CompraId id;

    @MapsId("usuarioId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", nullable = false)
    private com.tienda.model.Usuario usuario;

    @MapsId("productoId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "producto_id", nullable = false)
    private com.tienda.model.Producto producto;

    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id1;

    @ColumnDefault("1")
    @Column(name = "cantidad")
    private Integer cantidad;

    public CompraId getId() {
        return id;
    }

    public void setId(CompraId id) {
        this.id = id;
    }

    public com.tienda.model.Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(com.tienda.model.Usuario usuario) {
        this.usuario = usuario;
    }

    public com.tienda.model.Producto getProducto() {
        return producto;
    }

    public void setProducto(com.tienda.model.Producto producto) {
        this.producto = producto;
    }

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}