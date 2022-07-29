package ru.netology.data;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    public static void deleteData() throws SQLException {
        val deletePayment = "DELETE FROM payment_entity";
        val deleteCredit = "DELETE FROM credit_request_entity";
        val deleteOrder = "DELETE FROM order_entity";
        val runner = new QueryRunner();
        val connection = DriverManager.getConnection(System.getProperty("url"), ("app"), ("pass")); {
            runner.update(connection, deletePayment);
            runner.update(connection, deleteCredit);
            runner.update(connection, deleteOrder);
        }
    }

    public static String buyStatus() throws SQLException {
        val status = "SELECT status FROM payment_entity";
        return getDataBase(status);
    }

    public static String creditStatus() throws SQLException {
        val status = "SELECT status FROM credit_request_entity";
        return getDataBase(status);
    }

    private static String getDataBase(String query) throws SQLException {
        val runner = new QueryRunner();
        String dataBase = "";
        val connection = DriverManager.getConnection(System.getProperty("url"), ("app"), ("pass")); {
        //try (val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")) {
        //try (val connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "app", "pass")) {
            dataBase = (String) runner.query(connection, query, new ScalarHandler());
        }
        return dataBase;
    }
}