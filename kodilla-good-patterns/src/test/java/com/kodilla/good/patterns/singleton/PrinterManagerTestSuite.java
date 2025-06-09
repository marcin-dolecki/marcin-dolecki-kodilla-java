package com.kodilla.good.patterns.singleton;

import org.junit.jupiter.api.Test;

class PrinterManagerTestSuite {
    @Test
    void printTest() {
        PrinterManager printerManager = PrinterManager.INSTANCE;
        printerManager.print();
    }
}
