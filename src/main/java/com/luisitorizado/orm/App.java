package com.luisitorizado.orm;

import java.sql.Statement;

import com.luisitorizado.connection.ORMixPostgresSQLConnection;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ORMixPostgresSQLConnection connection = ORMixPostgresSQLConnection.getInstance("localhost", 5432,
                "smartparkinglot", "postgres", "root");
        IO.println("Conexxion: " + connection.getJdbcUrl());
        //Abrir la conexion: 
        IO.println(connection.OpenConnection());
        connection.OpenConnection();
        IO.println("Este es el inicio del ORM");
    }
}
