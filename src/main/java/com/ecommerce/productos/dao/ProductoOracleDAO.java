package com.ecommerce.productos.dao;

import com.ecommerce.productos.modelo.Producto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductoOracleDAO implements ProductoDAO {
    private final Map<Integer, Producto> productos = new HashMap<>();

    public ProductoOracleDAO() {
        // Precargar productos iniciales
        productos.put(1, new Producto(1, "Producto Oracle 1", 300.0));
        productos.put(2, new Producto(2, "Producto Oracle 2", 400.0));
    }

    @Override
    public void agregarProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    @Override
    public void actualizarProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    @Override
    public void eliminarProducto(int id) {
        productos.remove(id);
    }

    @Override
    public Producto obtenerProductoPorId(int id) {
        return productos.get(id);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productos.values().stream().collect(Collectors.toList());
    }
}
