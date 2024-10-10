package com.ecommerce.productos.factory;

import com.ecommerce.productos.dao.ProductoDAO;
import com.ecommerce.productos.dao.ProductoMySQLDAO;

public class MySQLFactory extends DAOFactory {
    @Override
    public ProductoDAO crearProductoDAO() {
        // Retorna una instancia de ProductoMySQLDAO
        return new ProductoMySQLDAO();
    }
}
