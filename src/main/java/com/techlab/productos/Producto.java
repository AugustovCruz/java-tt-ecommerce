package com.techlab.productos;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
    }

    public void restarStock(int cantidad) {
        if (cantidad > 0 && cantidad <= stock) {
            this.stock -= cantidad;
        } else {
            throw new IllegalArgumentException("Cantidad inválida para restar stock.");
        }
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s | Precio: %.2f | Stock: %d", nombre, precio, stock);
    }
}
