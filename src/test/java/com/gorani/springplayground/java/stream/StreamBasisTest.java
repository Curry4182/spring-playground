package com.gorani.springplayground.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StreamBasisTest {

    StreamBasis streamBasis = new StreamBasis();

    @Test
    @DisplayName("Test filtering even numbers")
    void testFilterEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> result = streamBasis.filterEvenNumbers(numbers);
        assertEquals(expected, result, "Filtered even numbers should be [2, 4, 6, 8, 10]");
    }

    @Test
    @DisplayName("Test squaring numbers")
    void testSquareNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 4, 9, 16, 25);
        List<Integer> result = streamBasis.squareNumbers(numbers);
        assertEquals(expected, result, "Squared numbers should be [1, 4, 9, 16, 25]");
    }

    @Test
    @DisplayName("Test summing numbers")
    void testSumOfNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> expected = Optional.of(15);
        Optional<Integer> result = streamBasis.sumOfNumbers(numbers);
        assertEquals(expected, result, "Sum of numbers should be 15");
    }

    @Test
    @DisplayName("Test sorting numbers")
    void testSortNumbers() {
        List<Integer> numbers = Arrays.asList(5, 3, 4, 1, 2);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = streamBasis.sortNumbers(numbers);
        assertEquals(expected, result, "Sorted numbers should be [1, 2, 3, 4, 5]");
    }

    @Test
    @DisplayName("Test creating stream from array")
    void testStreamFromArray() {
        String[] array = {"a", "b", "c", "d"};
        List<String> expected = Arrays.asList("a", "b", "c", "d");
        List<String> result = streamBasis.streamFromArray(array).collect(Collectors.toList());
        assertEquals(expected, result, "Stream from array should be [a, b, c, d]");
    }

    @Test
    @DisplayName("Test creating stream from list")
    void testStreamFromList() {
        List<String> stringList = Arrays.asList("one", "two", "three");
        List<String> expected = Arrays.asList("one", "two", "three");
        List<String> result = streamBasis.streamFromList(stringList).collect(Collectors.toList());
        assertEquals(expected, result, "Stream from list should be [one, two, three]");
    }

    @Test
    @DisplayName("Test flatMap example")
    void testFlatMapExample() {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );
        List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "f");
        List<String> result = streamBasis.flatMapExample(listOfLists);
        assertEquals(expected, result, "FlatMap example should be [a, b, c, d, e, f]");
    }

    @Test
    @DisplayName("Test distinct example")
    void testDistinctExample() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = streamBasis.distinctExample(duplicateNumbers);
        assertEquals(expected, result, "Distinct numbers should be [1, 2, 3, 4, 5]");
    }
}