package com.luisitorizado.connection.postgres;

import java.sql.Connection;
import java.sql.DriverManager;

import com.luisitorizado.connection.DBConfig;
import com.luisitorizado.connection.IDBConnection;

public class PostgresConnector implements IDBConnection {
    private final DBConfig config;

    public PostgresConnector(DBConfig config) {
        this.config = config;
    }

    public Connection connect() {
        IO.println("Logica de conexion a postgres");
        String connectionString = "jdbc:postgresql://" + config.getHost() + ":" + Integer.toString(config.getPort())
                + "/" + config.getDatabase();
        try {
            Connection conn = DriverManager.getConnection(connectionString, config.getUsername(), config.getPassword());
            if (conn.isValid(100)) {
                IO.println("Conectado!");
                return conn;
            } else
                return null;
        } catch (Exception e) {
            IO.println(e);
            return null;
        }
    }
}