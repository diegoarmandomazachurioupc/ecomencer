package com.ecommerce.productos.controller;

import com.ecommerce.productos.dao.ProductoDAO;
import com.ecommerce.productos.factory.DAOFactory;
import com.ecommerce.productos.modelo.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoDAO productoDAO;

    public ProductoController(DAOFactory factory) {
        this.productoDAO = factory.crearProductoDAO();
    }

    @GetMapping
    public List<Producto> obtenerTodosLosProductos() {
        return productoDAO.obtenerTodosLosProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        Producto producto = productoDAO.obtenerProductoPorId(id);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        productoDAO.agregarProducto(producto);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoActualizado) {
        productoActualizado.setId(id);
        productoDAO.actualizarProducto(productoActualizado);
        return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        productoDAO.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
