package com.ecommerce.productos.factory;

import com.ecommerce.productos.dao.ProductoDAO;

public abstract class DAOFactory {
    // Método abstracto que define la forma del objeto a crear
    public abstract ProductoDAO crearProductoDAO();
}
