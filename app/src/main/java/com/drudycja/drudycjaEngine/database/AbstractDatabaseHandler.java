package com.drudycja.drudycjaEngine.database;

public abstract class AbstractDatabaseHandler {
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
