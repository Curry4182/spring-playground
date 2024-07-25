package com.gorani.springplayground.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasis {

    // Method to demonstrate filtering
    public List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    // Method to demonstrate mapping
    public List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Method to demonstrate reducing
    public Optional<Integer> sumOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::sum);
    }

    // Method to demonstrate sorting
    public List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // Method to demonstrate creating a stream from an array
    public Stream<String> streamFromArray(String[] array) {
        return Arrays.stream(array);
    }

    // Method to demonstrate creating a stream from a list
    public Stream<String> streamFromList(List<String> list) {
        return list.stream();
    }

    // Method to demonstrate flatMapping
    public List<String> flatMapExample(List<List<String>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    // Method to demonstrate distinct
    public List<Integer> distinctExample(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}