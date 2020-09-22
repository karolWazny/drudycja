package com.drudycja.drudycjaEngine.database;

public abstract class AbstractDatabaseHandler {
    private ColumnCode[] columns;
    private String tableName;

    public AbstractDatabaseHandler(ColumnCode[] columns, String tableName) {
        this.columns = columns;
        this.tableName = tableName;
    }

    public String generateSqlCreateTable() {
        StringBuilder builder = new StringBuilder("CREATE TABLE ");
        builder.append(tableName)
                .append("(");
        for (int i = 0; i < columns.length - 1; i++) {
            builder.append(columns[i].generateCreateColumnSql())
                    .append(", ");
        }
        builder.append(columns[columns.length - 1].generateCreateColumnSql())
                .append(");");
        return builder.toString();
    }

    public static class ColumnCode {
        public final String columnName;
        public final String columnCreateCode;

        public ColumnCode(String columnName, String columnCreateCode) {
            this.columnName = columnName;
            this.columnCreateCode = columnCreateCode;
        }

        public String generateCreateColumnSql() {
            return columnName + " " + columnCreateCode;
        }
    }
}
