package com.gorani.springplayground.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
public class StreamBasisTest {

    StreamBasis streamBasis = new StreamBasis();

    @Test
    @DisplayName("Test filtering even numbers")
    void testFilterEvenNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // when
        List<Integer> result = streamBasis.filterEvenNumbers(numbers);

        // then
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);
        assertEquals(expected, result, "Filtered even numbers should be [2, 4, 6, 8, 10]");
    }

    @Test
    @DisplayName("Test squaring numbers")
    void testSquareNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when
        List<Integer> result = streamBasis.squareNumbers(numbers);

        // then
        List<Integer> expected = Arrays.asList(1, 4, 9, 16, 25);
        assertEquals(expected, result, "Squared numbers should be [1, 4, 9, 16, 25]");
    }

    @Test
    @DisplayName("Test summing numbers")
    void testSumOfNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when
        Optional<Integer> result = streamBasis.sumOfNumbers(numbers);

        // then
        Optional<Integer> expected = Optional.of(15);
        assertEquals(expected, result, "Sum of numbers should be 15");
    }

    @Test
    @DisplayName("Test sorting numbers")
    void testSortNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(5, 3, 4, 1, 2);

        // when
        List<Integer> result = streamBasis.sortNumbers(numbers);

        // then
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, result, "Sorted numbers should be [1, 2, 3, 4, 5]");
    }

    @Test
    @DisplayName("Test creating stream from array")
    void testStreamFromArray() {
        // given
        String[] array = {"a", "b", "c", "d"};

        // when
        List<String> result = streamBasis.streamFromArray(array).collect(Collectors.toList());

        // then
        List<String> expected = Arrays.asList("a", "b", "c", "d");
        assertEquals(expected, result, "Stream from array should be [a, b, c, d]");
    }

    @Test
    @DisplayName("Test creating stream from list")
    void testStreamFromList() {
        // given
        List<String> stringList = Arrays.asList("one", "two", "three");

        // when
        List<String> result = streamBasis.streamFromList(stringList).collect(Collectors.toList());

        // then
        List<String> expected = Arrays.asList("one", "two", "three");
        assertEquals(expected, result, "Stream from list should be [one, two, three]");
    }

    @Test
    @DisplayName("Test flatMap example")
    void testFlatMapExample() {
        // given
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );

        // when
        List<String> result = streamBasis.flatMapExample(listOfLists);

        // then
        List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "f");
        assertEquals(expected, result, "FlatMap example should be [a, b, c, d, e, f]");
    }

    @Test
    @DisplayName("Test distinct example")
    void testDistinctExample() {
        // given
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        // when
        List<Integer> result = streamBasis.distinctExample(duplicateNumbers);

        // then
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, result, "Distinct numbers should be [1, 2, 3, 4, 5]");
    }
}