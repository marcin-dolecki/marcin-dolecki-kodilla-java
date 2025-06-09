package com.kodilla.good.patterns.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoggerTestSuite {
    @Test
    void testGetLastLog() {
        Logger logger = Logger.INSTANCE;
        logger.log("Hello World");

        String lastLog = logger.getLastLog();

        assertEquals("Hello World", lastLog);
    }
}
