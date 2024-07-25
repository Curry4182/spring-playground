package com.gorani.springplayground.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StreamGenerateExampleTest {

    StreamGenerateExample example = new StreamGenerateExample();

    @Test
    @DisplayName("Test generating IntStream")
    void testGenerateIntStream() {
        // given
        int startInclusive = 1;
        int endExclusive = 10;

        // when
        List<Integer> result = example.generateIntStream(startInclusive, endExclusive).boxed().collect(Collectors.toList());

        // then
        List<Integer> expected = IntStream.range(startInclusive, endExclusive).boxed().collect(Collectors.toList());
        assertEquals(expected, result, "Generated IntStream should match the expected range.");
    }

    @Test
    @DisplayName("Test generating LongStream")
    void testGenerateLongStream() {
        // given
        long startInclusive = 1;
        long endExclusive = 10;

        // when
        List<Long> result = example.generateLongStream(startInclusive, endExclusive).boxed().collect(Collectors.toList());

        // then
        List<Long> expected = LongStream.range(startInclusive, endExclusive).boxed().collect(Collectors.toList());
        assertEquals(expected, result, "Generated LongStream should match the expected range.");
    }

    @Test
    @DisplayName("Test generating random numbers")
    void testGenerateRandomNumbers() {
        // given
        int limit = 10;

        // when
        List<Integer> result = example.generateRandomNumbers(limit).collect(Collectors.toList());

        // then
        assertEquals(limit, result.size(), "Generated random numbers should have the expected size.");
    }

    @Test
    @DisplayName("Test generating fixed value stream")
    void testGenerateFixedValueStream() {
        // given
        String value = "Hello";
        long limit = 5;

        // when
        List<String> result = example.generateFixedValueStream(value, limit).collect(Collectors.toList());

        // then
        List<String> expected = Stream.generate(() -> value).limit(limit).collect(Collectors.toList());
        assertEquals(expected, result, "Generated fixed value stream should match the expected values.");
    }

    @Test
    @DisplayName("Test filtering even numbers in range")
    void testFilterEvenNumbersInRange() {
        // given
        int startInclusive = 1;
        int endExclusive = 10;

        // when
        List<Integer> result = example.filterEvenNumbersInRange(startInclusive, endExclusive);

        // then
        List<Integer> expected = IntStream.range(startInclusive, endExclusive)
                .filter(n -> n % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
        assertEquals(expected, result, "Filtered even numbers should match the expected values.");
    }

    @Test
    @DisplayName("Test summing long range")
    void testSumOfLongRange() {
        // given
        long startInclusive = 1;
        long endExclusive = 10;

        // when
        OptionalLong result = example.sumOfLongRange(startInclusive, endExclusive);

        // then
        OptionalLong expected = LongStream.range(startInclusive, endExclusive).reduce(Long::sum);
        assertEquals(expected, result, "Sum of long range should match the expected value.");
    }

    @Test
    @DisplayName("Test squaring numbers in range")
    void testSquareNumbersInRange() {
        // given
        int startInclusive = 1;
        int endExclusive = 10;

        // when
        List<Integer> result = example.squareNumbersInRange(startInclusive, endExclusive);

        // then
        List<Integer> expected = IntStream.range(startInclusive, endExclusive)
                .map(n -> n * n)
                .boxed()
                .collect(Collectors.toList());
        assertEquals(expected, result, "Squared numbers should match the expected values.");
    }

    @Test
    @DisplayName("Test distinct random numbers")
    void testDistinctRandomNumbers() {
        // given
        int limit = 20;

        // when
        List<Integer> result = example.distinctRandomNumbers(limit);

        // then
        assertTrue(result.size() <= limit, "Distinct random numbers should have size less than or equal to the limit.");
        assertEquals(result.size(), result.stream().distinct().count(), "Distinct random numbers should have no duplicates.");
    }
}