package com.tienda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100, min = 5, message = "el tamaño debe ser de 5 a 100")
    @NotNull(message = "el campo no puede ser nulo")
    @Pattern(regexp = "^[a-zA-Z0-9 ´]*$", message = "solo puede contener caracteres alfanumericos")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull(message = "el campo no puede ser nulo")
    @Digits(integer = 4, fraction = 2)
    @DecimalMin(value = "0.00", message = "el valor no puede ser negativo")
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Lob
    @Column(name = "imagen")
    private String imagen;

    @NotNull(message = "el campo no puede ser nulo")
    @Min(value = 1, message = "el valor tiene que ser mayor a 0")
    @Column(name = "stock", nullable = false)
    private Integer stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}