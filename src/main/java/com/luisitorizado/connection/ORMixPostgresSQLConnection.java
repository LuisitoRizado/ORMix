package com.luisitorizado.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ORMixPostgresSQLConnection {

    private String Host;
    private String JdbcUrl;
    private int Port;
    private String DatabaseName;
    private String Username;
    private String Password;
    private static ORMixPostgresSQLConnection Instance;
    private Connection Connection;

    private ORMixPostgresSQLConnection(String host, int port, String databaseName, String username, String password) {
        this.Port = port;
        this.Host = host;
        this.DatabaseName = databaseName;
        this.JdbcUrl = "jdbc:postgresql://" + this.Host + ":" + Integer.toString(this.Port) + "/" + this.DatabaseName;
        this.Username = username;
        this.Password = password;
    }

    public boolean OpenConnection() {
        if (Instance != null) {
            try {
                Connection connection = DriverManager.getConnection(this.JdbcUrl, this.Username, this.Password);
                this.Connection = connection;
                IO.println("Connected to Postgres database");
                return true;
            } catch (Exception e) {
                IO.println(e);
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean CloseConnection() {
        if (this.Connection == null) {
            try {

                this.Connection.close();
                return true;
            } catch (Exception error) {
                IO.println("Error al cerrar la conexion: " + error.getMessage());
                return false;
            }
        } else {
            return false;
        }

    }

    public static ORMixPostgresSQLConnection getInstance(String host, int port, String databaseName, String username,
            String password) {
        if (Instance == null) {
            Instance = new ORMixPostgresSQLConnection(host, port, databaseName, username, password);
        }
        return Instance;
    }

    public String getJdbcUrl() {
        return this.JdbcUrl;
    }
}
