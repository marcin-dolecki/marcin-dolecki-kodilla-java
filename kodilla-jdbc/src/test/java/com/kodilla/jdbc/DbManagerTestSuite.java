package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DbManagerTestSuite {
    @Test
    void testConnection() throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        assertNotNull(dbManager.getConnection());
    }
}
