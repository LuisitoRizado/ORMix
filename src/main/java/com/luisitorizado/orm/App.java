package com.luisitorizado.orm;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.Timer;

import com.luisitorizado.annotations.Column;
import com.luisitorizado.annotations.Table;
import com.luisitorizado.connection.ConnectionFactory;
import com.luisitorizado.connection.DBConfig;
import com.luisitorizado.connection.IDBConnection;
import com.luisitorizado.connection.postgres.PostgresConnector;
import com.luisitorizado.core.EntityManager;
import com.luisitorizado.queries.query.QueryStatement;

public class App {
    public static void main(String[] args) {
        DBConfig dbConfig = new DBConfig("localhost", 5432, "smartparkinglot", "postgres", "root");
        IDBConnection connection = ConnectionFactory.getConnection("postgres", dbConfig);
        // Realizar la conexion
        connection.connect();

        EntityManager em = new EntityManager();
        User user = new User();
        user.setId(100);
        user.setEmail("laog.sonic4@gmail.com");
        user.setName("Luis Olivares");
        IO.println("Consulta de findById");
        em.findById(User.class, user.getId());
    }
}
