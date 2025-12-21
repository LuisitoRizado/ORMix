package com.luisitorizado.connection.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

import com.luisitorizado.connection.DBConfig;
import com.luisitorizado.connection.IDBConnection;

public class MySqlConnector implements IDBConnection {
    private final DBConfig config;

    public MySqlConnector(DBConfig config) {
        this.config = config;
    }

    public Connection connect() {
        IO.println("Logica de conexion a postgres");
        String connectionString = "jdbc:postgresql://" + this.config.getHost() + ":"
                + Integer.toString(this.config.getPort())
                + "/" + this.config.getDatabase();
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
