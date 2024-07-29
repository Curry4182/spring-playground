package com.gorani.springplayground.java.stream.basis;

import com.gorani.springplayground.java.stream.model.Student;
import com.gorani.springplayground.java.stream.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamIntermediateOperationsTest {

    StreamIntermediateOperations streamOps = new StreamIntermediateOperations();

    @Test
    @DisplayName("Test filtering even numbers")
    void testFilterEvenNumbers() {
        // given
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6);

        // when
        List<Integer> result = streamOps.filterEvenNumbers(numbers).collect(Collectors.toList());

        // then
        assertEquals(List.of(2, 4, 6), result, "Filtered even numbers should match the expected values.");
    }

    @Test
    @DisplayName("Test squaring numbers")
    void testSquareNumbers() {
        // given
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4);

        // when
        List<Integer> result = streamOps.squareNumbers(numbers).collect(Collectors.toList());

        // then
        assertEquals(List.of(1, 4, 9, 16), result, "Squared numbers should match the expected values.");
    }

    @Test
    @DisplayName("Test converting strings to uppercase")
    void testToUpperCase() {
        // given
        Stream<String> strings = Stream.of("a", "b", "c");

        // when
        List<String> result = streamOps.toUpperCase(strings).collect(Collectors.toList());

        // then
        assertEquals(List.of("A", "B", "C"), result, "Converted strings should match the expected values.");
    }

    @Test
    @DisplayName("Test extracting user names")
    void testGetUserNames() {
        // given
        Stream<User> users = Stream.of(new User("Alice"), new User("Bob"), new User("Charlie"));

        // when
        List<String> result = streamOps.getUserNames(users).collect(Collectors.toList());

        // then
        assertEquals(List.of("Alice", "Bob", "Charlie"), result, "Extracted user names should match the expected values.");
    }

    @Test
    @DisplayName("Test flattening a list of lists")
    void testFlatMap() {
        // given
        List<List<Integer>> listOfLists = List.of(List.of(1, 2, 3), List.of(4, 5, 6));

        // when
        List<Integer> result = streamOps.flatMap(listOfLists).collect(Collectors.toList());

        // then
        assertEquals(List.of(1, 2, 3, 4, 5, 6), result, "Flattened list should match the expected values.");
    }

    @Test
    @DisplayName("Test calculating average score")
    void testAvgScore() {
        // given
        List<Student> students = List.of(
                Student.builder().kor(80).eng(70).math(60).build(),
                Student.builder().kor(80).eng(70).math(90).build(),
                Student.builder().kor(90).eng(80).math(100).build()
        );

        // when
        OptionalDouble result = streamOps.avgScore(students);

        // then
        assertTrue(result.isPresent(), "Average score should be present.");
        assertEquals(80, result.getAsDouble(), "Average score should match the expected value.");
    }

    @Test
    @DisplayName("Test sorting students by Korean score")
    void testSortStudentsByKor() {
        // given
        List<Student> students = List.of(
                Student.builder().kor(80).eng(70).math(60).build(),
                Student.builder().kor(85).eng(75).math(95).build(),
                Student.builder().kor(90).eng(80).math(100).build()
        );

        // when
        List<Integer> result = streamOps.sortStudentsByKor(students).map(Student::kor).toList();

        // then
        assertEquals(List.of(90, 85, 80), result, "Sorted Korean scores should match the expected values.");
    }

    @Test
    @DisplayName("Test skipping first n elements")
    void testSkip() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        List<Integer> result = streamOps.skip(numbers, 3).collect(Collectors.toList());

        // then
        assertEquals(List.of(4, 5, 6), result, "Skipped elements should match the expected values.");
    }
}