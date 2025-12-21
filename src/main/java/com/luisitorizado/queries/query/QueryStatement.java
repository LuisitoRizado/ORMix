package com.luisitorizado.queries.query;

import javax.management.Query;

public class QueryStatement {
    // Atributo
    private String[] tables;
    private String[] columns;
    private String query;

    // Constructores
    public QueryStatement(String[] tables) {
        this.tables = new String[tables.length];
        setTables(tables);
    }

    public QueryStatement(String[] tables, String[] columns) {
        this.tables = new String[tables.length];
        setTables(tables);
        this.columns = new String[columns.length];
        setColumns(columns);
        this.query = buildQuery();
    }

    // Methods
    private void setTables(String[] tablesInput) {
        int index = 0;
        for (String table : tablesInput) {
            this.tables[index] = table;
            index++;
        }
    }

    private void setColumns(String[] columnsInput) {
        int index = 0;
        for (String column : columnsInput) {
            this.columns[index] = column;
            index++;
        }
    }

    private String buildQuery() {
        String query = "SELECT ";
        for (String column : this.columns) {
            query += column + ", ";
        }
        query += "FROM ";
        for (String table : this.tables) {
            query += table + ", ";
        }

        return query;
    }

    // Getters and Setters
    public String getQuery() {
        return this.query;
    }
}
