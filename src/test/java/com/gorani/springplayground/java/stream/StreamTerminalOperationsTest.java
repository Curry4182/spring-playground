package com.gorani.springplayground.java.stream;

import com.gorani.springplayground.java.stream.enums.ProductType;
import com.gorani.springplayground.java.stream.model.Product;
import com.gorani.springplayground.java.stream.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamTerminalOperationsTest {

    StreamTerminalOperations streamOps = new StreamTerminalOperations();

    @Test
    @DisplayName("Test getting count of stream elements")
    void testGetCount() {
        // given
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);

        // when
        long count = streamOps.getCount(intStream);

        // then
        assertEquals(5, count, "Count of stream elements should match the expected value.");
    }

    @Test
    @DisplayName("Test getting max value of stream elements")
    void testGetMax() {
        // given
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);

        // when
        Optional<Integer> max = streamOps.getMax(intStream);

        // then
        assertTrue(max.isPresent(), "Max value should be present.");
        assertEquals(5, max.get(), "Max value of stream elements should match the expected value.");
    }

    @Test
    @DisplayName("Test getting min value of IntStream elements")
    void testGetMin() {
        // given
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

        // when
        OptionalInt min = streamOps.getMin(intStream);

        // then
        assertTrue(min.isPresent(), "Min value should be present.");
        assertEquals(1, min.getAsInt(), "Min value of IntStream elements should match the expected value.");
    }

    @Test
    @DisplayName("Test getting sum of IntStream elements")
    void testGetSum() {
        // given
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

        // when
        int sum = streamOps.getSum(intStream);

        // then
        assertEquals(15, sum, "Sum of IntStream elements should match the expected value.");
    }

    @Test
    @DisplayName("Test getting average of IntStream elements")
    void testGetAverage() {
        // given
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

        // when
        OptionalDouble average = streamOps.getAverage(intStream);

        // then
        assertTrue(average.isPresent(), "Average should be present.");
        assertEquals(3.0, average.getAsDouble(), "Average of IntStream elements should match the expected value.");
    }

    @Test
    @DisplayName("Test reducing stream elements with identity and accumulator")
    void testReduce() {
        // given
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
        int identity = 0;
        BinaryOperator<Integer> accumulator = Integer::sum;

        // when
        int result = streamOps.reduce(intStream, identity, accumulator);

        // then
        assertEquals(15, result, "Reduced result should match the expected value.");
    }

    @Test
    @DisplayName("Test reducing stream elements in parallel with identity, accumulator, and combiner")
    void testReduceParallel() {
        // given
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
        int identity = 0;
        BinaryOperator<Integer> accumulator = Integer::sum;
        BinaryOperator<Integer> combiner = Integer::sum;

        // when
        int result = streamOps.reduceParallel(intStream, identity, accumulator, combiner);

        // then
        assertEquals(15, result, "Reduced result should match the expected value.");
    }

    @Test
    @DisplayName("Test collecting stream elements to a list")
    void testCollectToList() {
        // given
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);

        // when
        List<Integer> resultList = streamOps.collectToList(intStream);

        // then
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), resultList, "Collected list should match the expected value.");
    }

    @Test
    @DisplayName("Test converting IntStream elements to array")
    void testToArray() {
        // given
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

        // when
        int[] resultArray = streamOps.toArray(intStream);

        // then
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, resultArray, "Array should match the expected value.");
    }

    @Test
    @DisplayName("Test joining stream elements to a string")
    void testJoinToString() {
        // given
        Stream<String> stringStream = Stream.of("a", "b", "c");

        // when
        String result = streamOps.joinToString(stringStream);

        // then
        assertEquals("a, b, c", result, "Joined string should match the expected value.");
    }

    @Test
    @DisplayName("Test joining stream elements to a string with prefix, suffix, and delimiter")
    void testJoinToStringWithPrefixSuffixAndDelimiter() {
        // given
        Stream<String> stringStream = Stream.of("a", "b", "c");
        String delimiter = ", ";
        String prefix = "[";
        String suffix = "]";

        // when
        String result = streamOps.joinToStringWithPrefixSuffixAndDelimiter(stringStream, delimiter, prefix, suffix);

        // then
        assertEquals("[a, b, c]", result, "Joined string with prefix, suffix, and delimiter should match the expected value.");
    }

    @Test
    @DisplayName("Test getting summary statistics of IntStream elements")
    void testGetSummaryStatistics() {
        // given
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

        // when
        IntSummaryStatistics stats = streamOps.getSummaryStatistics(intStream);

        // then
        assertEquals(5, stats.getCount(), "Summary statistics count should match the expected value.");
        assertEquals(15, stats.getSum(), "Summary statistics sum should match the expected value.");
        assertEquals(3.0, stats.getAverage(), "Summary statistics average should match the expected value.");
        assertEquals(1, stats.getMin(), "Summary statistics min should match the expected value.");
        assertEquals(5, stats.getMax(), "Summary statistics max should match the expected value.");
    }

    @Test
    @DisplayName("Test grouping products by type")
    void testGroupByType() {
        // given
        List<Product> products = Arrays.asList(
                Product.builder().name("TV").price(1000).quantity(10).type(ProductType.ELECTRONICS).build(),
                Product.builder().name("Apple").price(1).quantity(100).type(ProductType.FOOD).build(),
                Product.builder().name("Laptop").price(2000).quantity(5).type(ProductType.ELECTRONICS).build()
        );

        // when
        Map<ProductType, List<Product>> groupedByType = streamOps.groupByType(products);

        // then
        assertEquals(2, groupedByType.get(ProductType.ELECTRONICS).size(), "Electronics products should match the expected count.");
        assertEquals(1, groupedByType.get(ProductType.FOOD).size(), "Food products should match the expected count.");
    }

    @Test
    @DisplayName("Test summing product prices by type")
    void testSumPriceByType() {
        // given
        List<Product> products = Arrays.asList(
                Product.builder().name("TV").price(1000).quantity(10).type(ProductType.ELECTRONICS).build(),
                Product.builder().name("Apple").price(1).quantity(100).type(ProductType.FOOD).build(),
                Product.builder().name("Laptop").price(2000).quantity(5).type(ProductType.ELECTRONICS).build()
        );

        // when
        Map<ProductType, Integer> summedPrices = streamOps.sumPriceByType(products);

        // then
        assertEquals(3000, summedPrices.get(ProductType.ELECTRONICS), "Sum of electronics product prices should match the expected value.");
        assertEquals(1, summedPrices.get(ProductType.FOOD), "Sum of food product prices should match the expected value.");
    }

    @Test
    @DisplayName("Test converting IntStream to LinkedList")
    void testToLinkedListIntStream() {
        // given
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

        // when
        LinkedList<Integer> resultList = streamOps.toLinkedList(intStream);

        // then
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), resultList, "LinkedList should match the expected value.");
    }

    @Test
    @DisplayName("Test converting Stream to LinkedList")
    void testToLinkedListStream() {
        // given
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);

        // when
        LinkedList<Integer> resultList = streamOps.toLinkedList(intStream);

        // then
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), resultList, "LinkedList should match the expected value.");
    }

    @Test
    @DisplayName("Test any match in stream")
    void testAnyMatch() {
        // given
        Stream<Student> studentStream = Stream.of(
                Student.builder().name("Alice").age(20).email("alice@example.com").kor(90).eng(85).math(80).build(),
                Student.builder().name("Bob").age(22).email("bob@example.com").kor(85).eng(80).math(75).build()
        );

        // when
        boolean result = streamOps.anyMatch(studentStream, "Alice");

        // then
        assertTrue(result, "Any match should return true if a student with the specified name is found.");
    }

    @Test
    @DisplayName("Test all match in stream by age")
    void testAllMatchAge() {
        // given
        Stream<Student> studentStream = Stream.of(
                Student.builder().name("Alice").age(20).email("alice@example.com").kor(90).eng(85).math(80).build(),
                Student.builder().name("Bob").age(20).email("bob@example.com").kor(85).eng(80).math(75).build()
        );

        // when
        boolean result = streamOps.allMatchAge(studentStream, 20);

        // then
        assertTrue(result, "All match should return true if all students have the specified age.");
    }

    @Test
    @DisplayName("Test none match in stream by kor score")
    void testNoneMatchKor() {
        // given
        Stream<Student> studentStream = Stream.of(
                Student.builder().name("Alice").age(20).email("alice@example.com").kor(90).eng(85).math(80).build(),
                Student.builder().name("Bob").age(22).email("bob@example.com").kor(85).eng(80).math(75).build()
        );

        // when
        boolean result = streamOps.noneMatchKor(studentStream, 80);

        // then
        assertTrue(result, "None match should return true if no student has the specified kor score.");
    }

    @Test
    @DisplayName("Test find first element in stream")
    void testFindFirst() {
        // given
        Stream<Student> studentStream = Stream.of(
                Student.builder().name("Alice").age(20).email("alice@example.com").kor(90).eng(85).math(80).build(),
                Student.builder().name("Bob").age(22).email("bob@example.com").kor(85).eng(80).math(75).build()
        );

        // when
        Optional<Student> result = streamOps.findFirst(studentStream);

        // then
        assertTrue(result.isPresent(), "Find first should return a student if the stream is not empty.");
        assertEquals("Alice", result.get().name(), "First student in the stream should match the expected value.");
    }
}