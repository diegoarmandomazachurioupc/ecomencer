package com.ecommerce.productos.dao;

import com.ecommerce.productos.modelo.Producto;

import java.util.List;

public interface ProductoDAO {
    void agregarProducto(Producto producto);
    void actualizarProducto(Producto producto);
    void eliminarProducto(int id);
    Producto obtenerProductoPorId(int id);
    List<Producto> obtenerTodosLosProductos();
}
