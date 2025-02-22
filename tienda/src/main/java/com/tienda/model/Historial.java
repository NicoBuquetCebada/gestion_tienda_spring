package com.tienda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "historial")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", nullable = false)
    private com.tienda.model.Usuario usuario;

    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "producto_id", nullable = false)
    private com.tienda.model.Producto producto;

    @NotNull
    @Column(name = "fecha_compra", nullable = false)
    private LocalDate fechaCompra;

    @ColumnDefault("1")
    @Column(name = "cantidad")
    private Integer cantidad;

    @Size(max = 100)
    @NotNull
    @Column(name = "tipo", nullable = false, length = 100)
    private String tipo;

    @Size(max = 200)
    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @JsonProperty("usuarioId")
    public Integer usuarioId() {
        return usuario.getId();
    }

    @JsonProperty("productoId")
    public Integer productoId() {
        return producto.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}