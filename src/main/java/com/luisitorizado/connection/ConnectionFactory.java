package com.luisitorizado.connection;

import java.sql.Connection;

import com.luisitorizado.connection.postgres.PostgresConnector;

public abstract class ConnectionFactory {

    public static IDBConnection getConnection(String type, DBConfig config) {
        switch (type) {
            case "postgres":
                return new PostgresConnector(config);
            default:
                return new PostgresConnector(config);
        }
    }
}
