package com.ecommerce.productos.factory;

import com.ecommerce.productos.dao.ProductoDAO;
import com.ecommerce.productos.dao.ProductoPostgreSQLDAO;

public class PostgreSQLFactory extends DAOFactory {
    @Override
    public ProductoDAO crearProductoDAO() {
        return new ProductoPostgreSQLDAO();
    }
}
