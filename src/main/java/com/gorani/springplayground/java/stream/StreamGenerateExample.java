package com.gorani.springplayground.java.stream;

import java.util.List;
import java.util.OptionalLong;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamGenerateExample {

    // Method to demonstrate generating IntStream
    public IntStream generateIntStream(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive);
    }

    // Method to demonstrate generating LongStream
    public LongStream generateLongStream(long startInclusive, long endExclusive) {
        return LongStream.range(startInclusive, endExclusive);
    }

    // Method to demonstrate generating Stream with random numbers
    public Stream<Integer> generateRandomNumbers(int limit) {
        Random random = new Random();
        return Stream.generate(() -> random.nextInt(100)).limit(limit);
    }

    // Method to demonstrate generating Stream with fixed value
    public Stream<String> generateFixedValueStream(String value, long limit) {
        return Stream.generate(() -> value).limit(limit);
    }

    // Method to demonstrate filtering with IntStream
    public List<Integer> filterEvenNumbersInRange(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive)
                .filter(n -> n % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    // Method to demonstrate summing with LongStream
    public OptionalLong sumOfLongRange(long startInclusive, long endExclusive) {
        return LongStream.range(startInclusive, endExclusive)
                .reduce(Long::sum);
    }

    // Method to demonstrate mapping with IntStream
    public List<Integer> squareNumbersInRange(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive)
                .map(n -> n * n)
                .boxed()
                .collect(Collectors.toList());
    }

    // Method to demonstrate distinct with generated random numbers
    public List<Integer> distinctRandomNumbers(int limit) {
        Random random = new Random();
        return Stream.generate(() -> random.nextInt(100))
                .limit(limit)
                .distinct()
                .collect(Collectors.toList());
    }
}