/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author arrut
 */
public class UsuarioDAO {
    
    private static final String SQL_INSERT = " "; 
    private static final String SQL_UPDATE = " ";
    private static final String SQL_DELETE = "";
    private static final String SQL_READ = " ";
    private static final String SQL_READ_ALL = " ";

    private Connection conexion;

     public Connection conectar() {
        String user = "postgres";
        String pwd = "280601";
        String url = "jdbc:postgresql://localhost:5432/Base3CM13";
        String pgDriver = "org.postgresql.Driver";
        try {
            Class.forName(pgDriver);
            conexion = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }
}
