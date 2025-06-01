package com.techlab.productos;

import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    private final List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> obtenerTodos() {
        return new ArrayList<>(productos); // Devuelve una copia para evitar modificaciones externas
    }

    public Producto buscarPorId(int id) {
        if (id >= 0 && id < productos.size()) {
            return productos.get(id);
        }
        return null;
    }

    public boolean eliminarProducto(int id) {
        if (id >= 0 && id < productos.size()) {
            productos.remove(id);
            return true;
        }
        return false;
    }
}
