package com.gorani.springplayground.java.stream.performance;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StreamSlowSinLoopPerformanceTest {

    @Autowired
    private StreamSlowSinLoopPerformance streamPerformance;

    private static final int MAX_SIZE = 100_000_000;

    private static double[] randomArr;

    private static List<Double> randomList;

    private static double actualMaxSin;

    @BeforeAll
    static void setUpAll() {
        // given
        randomArr = new Random().doubles(MAX_SIZE, 0, 100).toArray();
        randomList = Arrays.stream(randomArr).boxed().collect(Collectors.toList());
        actualMaxSin = randomList.stream()
                .mapToDouble(Math::sin)
                .map(Math::sin)
                .map(Math::sin)
                .max()
                .orElseThrow(() -> new RuntimeException("There should be at least one value."));
    }

    @Test
    @DisplayName("Array performance test using classic for loop")
    void testGetSlowSinByClassicForLoopAndArr() {
        // when
        double expectedMaxSin = streamPerformance.getSlowSinByClassicForLoopAndArr(randomArr);

        // then
        assertEquals(actualMaxSin, expectedMaxSin, 1e-9);
    }

    @Test
    @DisplayName("Stream performance test using classic for loop")
    void testGetSlowSinByClassicForLoopAndStream() {
        // when
        double expectedMaxSin = streamPerformance.getSlowSinByClassicForLoopAndStream(randomList);

        // then
        assertEquals(actualMaxSin, expectedMaxSin, 1e-9);
    }

    @Test
    @DisplayName("Stream performance test using stream")
    void testGetSlowSinByStreamLoop() {
        // when
        double expectedMaxSin = streamPerformance.getSlowSinByStreamLoop(randomList);

        // then
        assertEquals(actualMaxSin, expectedMaxSin, 1e-9);
    }
}