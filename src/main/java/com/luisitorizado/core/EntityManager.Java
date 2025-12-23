package com.luisitorizado.core;

import java.lang.reflect.Field;
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
        // Get all columns
        List<String> columns = ReflectionUtils.getAllColumns(entity);
        // Generate query
        IO.println(columns.toString());
        return columns.toString();

    }

    public <T> T findById(Class<T> entity, Object id) {
        String idName = ReflectionUtils.getIdName(entity);
        IO.println("Nombre del ID : " + idName);

        try {
            T dummy = entity.getDeclaredConstructor().newInstance();
            return dummy;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo crear dummy de " + entity.getName(), e);
        }
    }
}