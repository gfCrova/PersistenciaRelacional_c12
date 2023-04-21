package com.argPrograma.factory;

import com.argPrograma.Services.ConfigService;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

    public static Connection getConnection() {

        ConfigService load = new ConfigService();
        load.obtenerCofiguracion();

        String url = load.getUrl();
        String username = load.getUsername();
        String password = load.getPassword();

        String driverName = load.getDriver();

        Connection con = null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url,username,password);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
