package com.gorani.springplayground.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * wildcard 예제
 */
public class DataProcessor<T> {

    private final List<T> storage = new ArrayList<>();

    // Covariance, Produce
    public void processData(List<? extends T> sensorData) {
        for (T data : sensorData) {
            saveData(data);
        }
    }

    // Contravariance, Consumer
    public void addToExternalStorage(List<? super T> externalStorage, T data) {
        externalStorage.add(data);
    }

    private void saveData(T data) {
        storage.add(data);
    }

    public List<T> getStorageContents() {
        return new ArrayList<>(storage);
    }
}