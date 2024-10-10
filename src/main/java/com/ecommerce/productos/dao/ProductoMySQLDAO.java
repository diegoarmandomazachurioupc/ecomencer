package com.ecommerce.productos.dao;

import com.ecommerce.productos.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoMySQLDAO implements ProductoDAO {
    private final List<Producto> productos = new ArrayList<>();

    public ProductoMySQLDAO() {
        // Precargar productos iniciales
        productos.add(new Producto(1, "Producto MySQL 1", 100.0));
        productos.add(new Producto(2, "Producto MySQL 2", 200.0));
    }

    @Override
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public void actualizarProducto(Producto producto) {
        productos.removeIf(p -> p.getId() == producto.getId());
        productos.add(producto);
    }

    @Override
    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    @Override
    public Producto obtenerProductoPorId(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return new ArrayList<>(productos);
    }
}
