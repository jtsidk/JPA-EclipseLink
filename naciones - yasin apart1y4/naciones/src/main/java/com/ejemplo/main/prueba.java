package com.ejemplo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class prueba {
	    public static void main(String[] args) {
	        try {
	            Connection connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost/adat9?allowPublicKeyRetrieval=true",
	                "dam1",
	                "asdf.1234"
	            );
	            System.out.println("Conexión exitosa a la base de datos.");
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Error al conectar con la base de datos.");
	        }
	    }
	}



