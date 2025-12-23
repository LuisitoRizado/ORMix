package com.luisitorizado.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.luisitorizado.annotations.Column;
import com.luisitorizado.annotations.Id;
import com.luisitorizado.annotations.Table;
import com.luisitorizado.connection.ConnectionFactory;
import com.luisitorizado.connection.IDBConnection;
import com.luisitorizado.utils.ReflectionUtils;

public class EntityManager {

    private IDBConnection conn;

    public EntityManager(IDBConnection conn) {
        this.conn = conn;
        conn.connect();
    }

    public <T> void insertOne(T entity) {

    }

    public <T> String findAll(Class<T> entity, Object id) {
        List<String> columns = ReflectionUtils.getAllColumns(entity);

        IO.println(columns.toString());
        return columns.toString();

    }

    public <T> boolean findById(Class<T> entity, Object id) {
        try {

            String idName = ReflectionUtils.getIdName(entity);
            Connection connection = conn.connect();
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM cajon";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                IO.println(rs.getString("codigo"));
                // Obtiene los datos de la consulta
            }

            return true;
        } catch (Exception e) {
            IO.println(e);
            return false;
        }
    }
}