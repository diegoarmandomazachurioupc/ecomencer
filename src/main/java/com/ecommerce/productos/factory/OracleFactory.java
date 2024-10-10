package com.ecommerce.productos.factory;

import com.ecommerce.productos.dao.ProductoDAO;
import com.ecommerce.productos.dao.ProductoOracleDAO;

public class OracleFactory extends DAOFactory {
    @Override
    public ProductoDAO crearProductoDAO() {
        // Retorna una instancia de ProductoOracleDAO
        return new ProductoOracleDAO();
    }
}
