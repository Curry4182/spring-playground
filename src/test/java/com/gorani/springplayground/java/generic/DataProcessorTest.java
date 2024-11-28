package com.gorani.springplayground.java.generic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DataProcessorTest {

    @Test
    void shouldProcessDataAndStoreInternally() {
        // Given
        DataProcessor<Number> numberProcessor = new DataProcessor<>();
        List<Integer> integerData = List.of(10, 20);
        List<Double> doubleData = List.of(15.5, 25.5);

        // When
        numberProcessor.processData(integerData);
        numberProcessor.processData(doubleData);

        // Then
        List<Number> storageContents = numberProcessor.getStorageContents();
        assertEquals(4, storageContents.size(), "Storage should contain 4 elements");
        assertTrue(storageContents.contains(10), "Storage should contain 10");
        assertTrue(storageContents.contains(20), "Storage should contain 20");
        assertTrue(storageContents.contains(15.5), "Storage should contain 15.5");
        assertTrue(storageContents.contains(25.5), "Storage should contain 25.5");
    }

    @Test
    void shouldAddDataToExternalStorage() {
        // Given
        DataProcessor<Number> numberProcessor = new DataProcessor<>();
        List<Object> externalStorage = new ArrayList<>();

        // When
        numberProcessor.addToExternalStorage(externalStorage, 100);
        numberProcessor.addToExternalStorage(externalStorage, 200.5);

        // Then
        assertEquals(2, externalStorage.size(), "External storage should contain 2 elements");
        assertTrue(externalStorage.contains(100), "External storage should contain 100");
        assertTrue(externalStorage.contains(200.5), "External storage should contain 200.5");
    }

    @Test
    void shouldProcessAndAddToExternalStorage() {
        // Given
        DataProcessor<Number> numberProcessor = new DataProcessor<>();
        List<Integer> integerData = List.of(10, 20);
        List<Double> doubleData = List.of(15.5, 25.5);
        List<Object> externalStorage = new ArrayList<>();

        // When
        numberProcessor.processData(integerData);
        numberProcessor.processData(doubleData);
        numberProcessor.addToExternalStorage(externalStorage, 30);
        numberProcessor.addToExternalStorage(externalStorage, 40.5);

        // Then
        List<Number> storageContents = numberProcessor.getStorageContents();
        assertEquals(4, storageContents.size(), "Internal storage should contain 4 elements");
        assertTrue(storageContents.contains(10), "Internal storage should contain 10");
        assertTrue(storageContents.contains(20), "Internal storage should contain 20");
        assertTrue(storageContents.contains(15.5), "Internal storage should contain 15.5");
        assertTrue(storageContents.contains(25.5), "Internal storage should contain 25.5");

        assertEquals(2, externalStorage.size(), "External storage should contain 2 elements");
        assertTrue(externalStorage.contains(30), "External storage should contain 30");
        assertTrue(externalStorage.contains(40.5), "External storage should contain 40.5");
    }
}