package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DbManagerTestSuite {
    @Test
    void testConnection() throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUser() throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "select * from USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        int counter = 0;
        while (resultSet.next()) {
            System.out.println(
                    resultSet.getInt("ID") + ", " +
                    resultSet.getString("FIRSTNAME") + ", " +
                    resultSet.getString("LASTNAME")
            );
            counter++;
        }
        resultSet.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndTasks() throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = """
            select u.FIRSTNAME, u.LASTNAME, i.SUMMARY
            from USERS u
            join ISSUES i on u.ID = i.USER_ID_ASSIGNEDTO
        """;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        int counter = 0;
        while (resultSet.next()) {
            System.out.println(
                    resultSet.getString("FIRSTNAME") + ", " +
                    resultSet.getString("LASTNAME") + ", " +
                    resultSet.getString("SUMMARY")
            );
            counter++;
        }
        resultSet.close();
        statement.close();
        assertEquals(12, counter);
    }
}
