package com.gorani.springplayground.java.stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StreamNormalLoopPerformanceTest {

    @Autowired
    private StreamNormalLoopPerformance streamPerformance;

    private static final int MAX_SIZE = 100_000_000;

    private static int[] randomArr;

    private static List<Integer> randomList;

    private static int actualMax;

    @BeforeAll
    static void setUpAll() {
        // given
        randomArr = new Random().ints(MAX_SIZE, 0, 100).toArray();
        randomList = Arrays.stream(randomArr).boxed().toList();
        actualMax = randomList.stream().max(Comparator.naturalOrder()).orElseThrow(() -> new RuntimeException("There should be at least one value."));
    }

    @Test
    @DisplayName("Array performance test using classic for loop")
    void testGetMaxNumByClassicForLoopByArr() {
        // when
        int expectedMax = streamPerformance.getMaxNumByClassicForLoopAndArr(randomArr);

        // then
        assertEquals(actualMax, expectedMax);
    }

    @Test
    @DisplayName("Stream performance test using classic for loop")
    void testGetMaxNumByClassicForLoopByStream() {
        // when
        Integer expectedMax = streamPerformance.getMaxNumByClassicForLoopAndStream(randomList);

        // then
        assertEquals(actualMax, expectedMax);
    }

    @Test
    @DisplayName("Stream performance test using stream")
    void testGetMaxNumByStreamLoop() {
        // when
        Integer expectedMax = streamPerformance.getMaxNumByStreamLoop(randomList);

        // then
        assertEquals(actualMax, expectedMax);
    }
}