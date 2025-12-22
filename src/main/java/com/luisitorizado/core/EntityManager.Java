package com.luisitorizado.core;

import java.lang.reflect.Field;

import com.luisitorizado.annotations.Column;
import com.luisitorizado.annotations.Id;
import com.luisitorizado.annotations.Table;

public class EntityManager {

    public <T> void insertOne(T entity) {
        // Leer los campos de la entidad

    }

    public <T> T findById(Class<T> entity, Object id) {
        // Ojo: entity es ya la clase, no necesitas entity.getClass()
        Table table = entity.getAnnotation(Table.class);
        String tableName = table.name();

        IO.println(entity.getDeclaredFields().toString());
        for (Field field : entity.getDeclaredFields()) {
            IO.println("Entro al ciclo!");
            if (!field.isAnnotationPresent(Id.class)) {
                Column columnId = field.getAnnotation(Column.class);
                // Lógica de consulta (dummy)
                String query = "SELECT * FROM " + tableName + " WHERE " + columnId.name() + " = " + id.toString();
                IO.println(query);
                break;
            }
        }

        try {
            // Crear instancia dummy de la entidad
            T dummy = entity.getDeclaredConstructor().newInstance();
            return dummy;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo crear dummy de " + entity.getName(), e);
        }
    }
}