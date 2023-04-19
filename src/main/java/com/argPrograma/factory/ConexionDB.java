package com.argPrograma.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

    public static Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/qatar2022";
        String username = "userJava";
        String password = "Java_Proyect";

        String driverName = "com.mysql.cj.jdbc.Driver";

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
