package com.gorani.springplayground.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * wildcard 예제
 */
public class DataProcessor<T> {

    private final List<T> storage = new ArrayList<>();

    // Covariance
    public void processData(List<? extends T> sensorData) {
        for (T data : sensorData) { // produce - 컬렉션으로부터 원소들을 꺼내면서 T(type parameter) Type 객체를 생성(produce)하고 있다.
            saveData(data);
        }
    }

    // Contravariance
    public void addToExternalStorage(List<? super T> externalStorage, T data) {
        externalStorage.add(data); // consume - T(type parameter) Type 객체를 소비(consume)하고 있다.
    }

    private void saveData(T data) {
        storage.add(data);
    }

    public List<T> getStorageContents() {
        return new ArrayList<>(storage);
    }
}