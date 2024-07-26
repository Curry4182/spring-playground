package com.gorani.springplayground.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StreamFactoryTest {

    StreamFactory streamFactory = new StreamFactory();

    @Test
    @DisplayName("Test creating a stream from an array")
    void testStreamFromArray() {
        // given
        String[] array = {"a", "b", "c"};

        // when
        List<String> result = streamFactory.streamFromArray(array).collect(Collectors.toList());

        // then
        assertEquals(List.of("a", "b", "c"), result, "Stream from array should match the expected values.");
    }

    @Test
    @DisplayName("Test creating a stream from a list")
    void testStreamFromList() {
        // given
        List<String> list = List.of("a", "b", "c");

        // when
        List<String> result = streamFactory.streamFromList(list).collect(Collectors.toList());

        // then
        assertEquals(list, result, "Stream from list should match the expected values.");
    }

    @Test
    @DisplayName("Test creating a stream using Stream.builder")
    void testStreamFromArgs() {
        // given
        String s1 = "a";
        String s2 = "b";
        String s3 = "c";

        // when
        List<String> result = streamFactory.streamFromArgs(s1, s2, s3).collect(Collectors.toList());

        // then
        assertEquals(List.of(s1, s2, s3), result, "Stream from args should match the expected values.");
    }

    @Test
    @DisplayName("Test generating Stream with fixed value")
    void testGenerateFixedValueStream() {
        // given
        String value = "Hello";
        long limit = 5;

        // when
        List<String> result = streamFactory.generateFixedValueStream(value, limit).collect(Collectors.toList());

        // then
        List<String> expected = Stream.generate(() -> value).limit(limit).collect(Collectors.toList());
        assertEquals(expected, result, "Generated fixed value stream should match the expected values.");
    }

    @Test
    @DisplayName("Test generating Stream by iterating with a step of 2")
    void testGenerateStreamThatPlusNumsByTwo() {
        // given
        int seed = 0;
        int maxSize = 5;

        // when
        List<Integer> result = streamFactory.generateStreamThatPlusNumsByTwo(seed, maxSize).collect(Collectors.toList());

        // then
        List<Integer> expected = Stream.iterate(seed, n -> n + 2).limit(maxSize).collect(Collectors.toList());
        assertEquals(expected, result, "Generated stream by iterating with a step of 2 should match the expected values.");
    }

    @Test
    @DisplayName("Test generating IntStream")
    void testGenerateIntStream() {
        // given
        int startInclusive = 1;
        int endExclusive = 10;

        // when
        List<Integer> result = streamFactory.generateIntStream(startInclusive, endExclusive).boxed().collect(Collectors.toList());

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
        List<Long> result = streamFactory.generateLongStream(startInclusive, endExclusive).boxed().collect(Collectors.toList());

        // then
        List<Long> expected = LongStream.range(startInclusive, endExclusive).boxed().collect(Collectors.toList());
        assertEquals(expected, result, "Generated LongStream should match the expected range.");
    }

    @Test
    @DisplayName("Test generating boxed IntStream")
    void testGenerateBoxedIntStream() {
        // given
        int startInclusive = 1;
        int endExclusive = 10;

        // when
        List<Integer> result = streamFactory.generateBoxedIntStream(startInclusive, endExclusive).collect(Collectors.toList());

        // then
        List<Integer> expected = IntStream.range(startInclusive, endExclusive).boxed().collect(Collectors.toList());
        assertEquals(expected, result, "Generated boxed IntStream should match the expected range.");
    }

    @Test
    @DisplayName("Test generating boxed LongStream")
    void testGenerateBoxedLongStream() {
        // given
        long startInclusive = 1;
        long endExclusive = 10;

        // when
        List<Long> result = streamFactory.generateBoxedLongStream(startInclusive, endExclusive).collect(Collectors.toList());

        // then
        List<Long> expected = LongStream.range(startInclusive, endExclusive).boxed().collect(Collectors.toList());
        assertEquals(expected, result, "Generated boxed LongStream should match the expected range.");
    }

    @Test
    @DisplayName("Test generating IntStream from a string's characters")
    void testGenerateCharStream() {
        // given
        String s = "abc";

        // when
        List<Integer> result = streamFactory.generateCharStream(s).boxed().collect(Collectors.toList());

        // then
        List<Integer> expected = s.chars().boxed().collect(Collectors.toList());
        assertEquals(expected, result, "Generated IntStream from a string's characters should match the expected values.");
    }

    @Test
    @DisplayName("Test generating Stream from a comma-separated string")
    void testGenerateSplitStream() {
        // given
        String s = "a,b,c";

        // when
        List<String> result = streamFactory.generateSplitStream(s).collect(Collectors.toList());

        // then
        List<String> expected = List.of("a", "b", "c");
        assertEquals(expected, result, "Generated Stream from a comma-separated string should match the expected values.");
    }

    @Test
    @DisplayName("Test generating Stream from a regex split string")
    void testGenerateRegexStream() {
        // given
        String s = "a b c";

        // when
        List<String> result = streamFactory.generateRegexStream(s).collect(Collectors.toList());

        // then
        List<String> expected = List.of("a", "b", "c");
        assertEquals(expected, result, "Generated Stream from a regex split string should match the expected values.");
    }

    @Test
    @DisplayName("Test generating parallel Stream and adding 2 to each element from a list")
    void testGenerateParallelStreamThatPlusNumsByTwoList() {
        // given
        List<Integer> list = List.of(1, 2, 3);

        // when
        List<Integer> result = streamFactory.generateParallelStreamThatPlusNumsByTwo(list).collect(Collectors.toList());

        // then
        List<Integer> expected = list.stream().map(n -> n + 2).collect(Collectors.toList());
        assertEquals(expected, result, "Generated parallel Stream and adding 2 to each element from a list should match the expected values.");
    }

    @Test
    @DisplayName("Test generating parallel Stream and adding 2 to each element from an array")
    void testGenerateParallelStreamThatPlusNumsByTwoArray() {
        // given
        Integer[] array = {1, 2, 3};

        // when
        List<Integer> result = streamFactory.generateParallelStreamThatPlusNumsByTwo(array).collect(Collectors.toList());

        // then
        List<Integer> expected = Arrays.stream(array).map(n -> n + 2).collect(Collectors.toList());
        assertEquals(expected, result, "Generated parallel Stream and adding 2 to each element from an array should match the expected values.");
    }

    @Test
    @DisplayName("Test transforming a parallel Stream to a sequential Stream")
    void testTransformToSequentialStream() {
        // given
        Stream<Integer> parallelStream = List.of(1, 2, 3).parallelStream();

        // when
        Stream<Integer> result = streamFactory.transformToSequentialStream(parallelStream);

        // then
        assertFalse(result.isParallel(), "Transformed Stream should be sequential.");
    }

    @Test
    @DisplayName("Test checking if a Stream is parallel")
    void testIsParallel() {
        // given
        Stream<Integer> parallelStream = List.of(1, 2, 3).parallelStream();
        Stream<Integer> sequentialStream = Stream.of(1, 2, 3);

        // when
        boolean isParallel = streamFactory.isParallel(parallelStream);
        boolean isSequential = streamFactory.isParallel(sequentialStream);

        // then
        assertTrue(isParallel, "Stream should be parallel.");
        assertFalse(isSequential, "Stream should be sequential.");
    }

    @Test
    @DisplayName("Test concatenating two Streams")
    void testConcatStreams() {
        // given
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);

        // when
        List<Integer> result = streamFactory.concatStreams(stream1, stream2).collect(Collectors.toList());

        // then
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result, "Concatenated Streams should match the expected values.");
    }
}