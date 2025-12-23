package com.luisitorizado.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.luisitorizado.annotations.Column;
import com.luisitorizado.annotations.Id;
import com.luisitorizado.annotations.Table;

public class ReflectionUtils {

    // Saca los utils de reflection
    public static <T> List<String> getAllColumns(Class<T> entity) {
        List<String> columns = new ArrayList<>();
        for (Field field : entity.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                columns.add(column.name());
            }
        }
        return columns;
    }

    public static <T> String getIdName(Class<T> entity) {
        Id id = null;
        for (Field field : entity.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                id = field.getAnnotation(Id.class);
                break;
            }
        }
        // Aquí id puede seguir siendo null si ningún campo tenía @Id
        return id.name(); // NullPointerException

    }

}
