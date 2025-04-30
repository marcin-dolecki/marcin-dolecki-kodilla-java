package com.kodilla.exeption.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTestSuite {
    FileReader fileReader;

    @BeforeEach
    void beforeEach() {
        //given
        fileReader = new FileReader();
    }

    @Test
    void testReadFile() {
        //when & then
        assertDoesNotThrow(() -> fileReader.readFile());
    }

    @Test
    void testReadFileWithFileName() {
        //when & then
        assertDoesNotThrow(() -> fileReader.readFile("names.txt"));
    }

    @Test
    void testReadFileWithWrongFileName() {
        //when & then
        assertThrows(FileReaderException.class, () -> fileReader.readFile("wrong_file.txt"));
    }

    @Test
    void testReadFileAll() {
        //when & then
        assertAll(
            () -> assertDoesNotThrow(() -> fileReader.readFile()),
            () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt")),
            () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("wrong_file.txt")),
            () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null))
        );
    }
}
