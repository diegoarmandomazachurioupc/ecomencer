package com.ecommerce.productos.config;

import com.ecommerce.productos.factory.DAOFactory;
import com.ecommerce.productos.factory.MySQLFactory;
import com.ecommerce.productos.factory.OracleFactory;
import com.ecommerce.productos.factory.PostgreSQLFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Configuracion {

    private static final Map<String, DAOFactory> factories = new HashMap<>();

    static {
        // Registramos las fábricas disponibles
        factories.put("MySQL", new MySQLFactory());
        factories.put("Oracle", new OracleFactory());
        factories.put("Posgrest", new PostgreSQLFactory());

    }

    @Bean
    public DAOFactory obtenerFactory() {
        String tipoBD = obtenerTipoBaseDeDatosDesdeConfiguracion();
        DAOFactory factory = factories.get(tipoBD);
        if (factory == null) {
            throw new IllegalArgumentException("Tipo de base de datos no soportado: " + tipoBD);
        }
        return factory;
    }

    public static String obtenerTipoBaseDeDatosDesdeConfiguracion() {
        // Simulación de una configuración externa
        return "Oracle"; // Cambiar a "MySQL" para simular la otra base de datos
    }
}
