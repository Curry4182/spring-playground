package com.gorani.springplayground.java.stream.basis;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Component
public class StreamInitialOperions {

    // Method to demonstrate creating a stream from an array
    public Stream<String> streamFromArray(String[] array) {
        return Arrays.stream(array);
    }

    // Method to demonstrate creating a stream from a list
    public Stream<String> streamFromList(List<String> list) {
        return list.stream();
    }

    // Method to demonstrate creating a stream using Stream.builder
    public Stream<String> streamFromArgs(String s1, String s2, String s3) {
        return Stream.<String>builder()
                .add(s1)
                .add(s2)
                .add(s3)
                .build();
    }

    // Method to demonstrate generating Stream with fixed value
    public Stream<String> generateFixedValueStream(String value, long limit) {
        return Stream.generate(() -> value).limit(limit);
    }

    // Method to demonstrate generating Stream by iterating with a step of 2
    public Stream<Integer> generateStreamThatPlusNumsByTwo(int seed, int maxSize) {
        return Stream.iterate(seed, n -> n + 2).limit(maxSize);
    }

    // Method to demonstrate generating IntStream
    public IntStream generateIntStream(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive);
    }

    // Method to demonstrate generating LongStream
    public LongStream generateLongStream(long startInclusive, long endExclusive) {
        return LongStream.range(startInclusive, endExclusive);
    }

    // Method to demonstrate generating boxed IntStream
    public Stream<Integer> generateBoxedIntStream(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive).boxed();
    }

    // Method to demonstrate generating boxed LongStream
    public Stream<Long> generateBoxedLongStream(long startInclusive, long endExclusive) {
        return LongStream.range(startInclusive, endExclusive).boxed();
    }

    // Method to demonstrate generating IntStream from a string's characters
    public IntStream generateCharStream(String s) {
        return s.chars();
    }

    // Method to demonstrate generating Stream from a comma-separated string
    public Stream<String> generateSplitStream(String s) {
        return Stream.of(s.split(","));
    }

    // Method to demonstrate generating Stream from a regex split string
    public Stream<String> generateRegexStream(String s) {
        return Stream.of(s.split("\\s+"));
    }

    // Method to demonstrate generating parallel Stream and adding 2 to each element
    public Stream<Integer> generateParallelStreamThatPlusNumsByTwo(List<Integer> list) {
        return list.parallelStream().map(n -> n + 2);
    }

    // Method to demonstrate generating parallel Stream from array and adding 2 to each element
    public Stream<Integer> generateParallelStreamThatPlusNumsByTwo(Integer[] array) {
        return Arrays.stream(array).parallel().map(n -> n + 2);
    }

    // Method to transform a parallel Stream to a sequential Stream
    public Stream<Integer> transformToSequentialStream(Stream<Integer> parallelStream) {
        return parallelStream.sequential();
    }

    // Method to check if a Stream is parallel
    public boolean isParallel(Stream<Integer> stream) {
        return stream.isParallel();
    }

    // Method to concatenate two Streams
    public Stream<Integer> concatStreams(Stream<Integer> stream1, Stream<Integer> stream2) {
        return Stream.concat(stream1, stream2);
    }
}