package com.luisitorizado.orm;

import java.sql.Statement;
import java.util.Timer;

import com.luisitorizado.connection.ConnectionFactory;
import com.luisitorizado.connection.DBConfig;
import com.luisitorizado.connection.IDBConnection;
import com.luisitorizado.connection.postgres.PostgresConnector;
import com.luisitorizado.queries.query.QueryStatement;

 
public class App {
    public static void main(String[] args) {
        DBConfig dbConfig = new DBConfig("localhost", 5432, "smartparkinglot", "postgres", "root");
        IDBConnection connection = ConnectionFactory.getConnection("postgres", dbConfig);
        //Realizar la conexion
        connection.connect();
    }
}
