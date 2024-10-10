package com.ecommerce.productos.dao;

import com.ecommerce.productos.modelo.Producto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductoPostgreSQLDAO implements ProductoDAO {
    private final Map<Integer, Producto> productos;

    public ProductoPostgreSQLDAO() {
        this.productos = new HashMap<>();
        // Precargar productos por defecto
        precargarProductos();
    }

    private void precargarProductos() {
        productos.put(1, new Producto(1, "Producto PostgreSQL 1", 150.0));
        productos.put(2, new Producto(2, "Producto PostgreSQL 2", 250.0));
    }

    @Override
    public void agregarProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    @Override
    public Producto obtenerProductoPorId(int id) {
        return productos.get(id);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productos.values().stream().collect(Collectors.toList());
    }

    @Override
    public void actualizarProducto(Producto producto) {
        if (productos.containsKey(producto.getId())) {
            productos.put(producto.getId(), producto);
        }
    }

    @Override
    public void eliminarProducto(int id) {
        productos.remove(id);
    }
}
