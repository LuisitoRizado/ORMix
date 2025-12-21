package com.luisitorizado.connection.mysql;

import java.sql.Connection;

import com.luisitorizado.connection.IDBConnection;

public class MySqlConnector implements IDBConnection {

    public Connection connect() {
        IO.println("Logica conexion de mysql");

        return null;
    }
}
