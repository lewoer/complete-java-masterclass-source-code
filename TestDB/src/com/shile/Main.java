package com.shile;

import java.sql.*;

public class Main {
    /**
     * 1. ResultSet 是一个数据表格,代表数据库返回结果集, 通常由查询数据的执行语句生成,ResultSet对象包含
     * 一个游标指针指向数据的当前行,.用完需要关闭
     * */

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:/masterjavaproject/TestDB/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                                    " (" +  COLUMN_NAME + " text, " +
                                            COLUMN_PHONE + " integer, " +
                                            COLUMN_EMAIL +  " text " +
                                    " )");

            insertContacts(statement,"Tim", 89743, "tim@email.com");
            insertContacts(statement,"Joe", 678545, "Joe@email.com");
            insertContacts(statement,"Jane", 567234, "Jane@email.com");
            insertContacts(statement,"Fido", 23446, "Fido@email.com");

//            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
//                                    COLUMN_PHONE + " = 329487" + " WHERE " + COLUMN_NAME  + " = johp");
//            statement.execute("DELETE FROM " + TABLE_CONTACTS +
//                                " WHERE " + COLUMN_NAME + " = lops");

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " +
                                   results.getInt(COLUMN_PHONE) + " " +
                                    results.getString(COLUMN_EMAIL));
            }

            results.close();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("something went wrong" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertContacts(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL +
                ") " +
                "VALUES(" + name + ", " + phone + ", " + email + ")");
    }
}
