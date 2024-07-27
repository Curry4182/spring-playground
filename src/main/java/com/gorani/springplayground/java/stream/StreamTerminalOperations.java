package com.gorani.springplayground.java.stream;

import com.gorani.springplayground.java.stream.enums.ProductType;
import com.gorani.springplayground.java.stream.model.Product;
import com.gorani.springplayground.java.stream.model.Student;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTerminalOperations {

    public long getCount(Stream<Integer> intStream) {
        return intStream.count();
    }

    public Optional<Integer> getMax(Stream<Integer> intStream) {
        return intStream.max(Integer::compareTo);
    }

    public OptionalInt getMin(IntStream intStream) {
        return intStream.min();
    }

    public int getSum(IntStream intStream) {
        return intStream.sum();
    }

    public OptionalDouble getAverage(IntStream intStream) {
        return intStream.average();
    }

    public int reduce(
            Stream<Integer> intStream,
            int identity,
            BinaryOperator<Integer> accumulator
    ) {
        return intStream.reduce(identity, accumulator);
    }

    public int reduceParallel(
            Stream<Integer> intStream,
            int identity,
            BinaryOperator<Integer> accumulator,
            BinaryOperator<Integer> combiner
    ) {
        return intStream.parallel().reduce(identity, accumulator, combiner);
    }

    public List<Integer> collectToList(Stream<Integer> intStream) {
        return intStream.collect(Collectors.toList());
    }

    public int[] toArray(IntStream intStream) {
        return intStream.toArray();
    }

    public String joinToString(Stream<String> stringStream) {
        return stringStream.collect(Collectors.joining(", "));
    }

    public String joinToStringWithPrefixSuffixAndDelimiter(
            Stream<String> stringStream,
            String delimiter,
            String prefix,
            String suffix
    ) {
        return stringStream.collect(Collectors.joining(delimiter, prefix, suffix));
    }

    public IntSummaryStatistics getSummaryStatistics(IntStream intStream) {
        return intStream.summaryStatistics();
    }

    public Map<ProductType, List<Product>> groupByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::type));
    }

    public Map<ProductType, Integer> sumPriceByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::type, Collectors.summingInt(Product::price)));
    }

    public LinkedList<Integer> toLinkedList(IntStream intStream) {
        return intStream.boxed()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public LinkedList<Integer> toLinkedList(Stream<Integer> intStream) {
        Collector<Integer, ?, LinkedList<Integer>> toLinkedList = Collector.of(
                LinkedList::new,
                LinkedList::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                }
        );

        return intStream.collect(toLinkedList);
    }

    public boolean anyMatch(Stream<Student> studentStream, String name) {
        return studentStream.anyMatch(s -> s.name().equals(name));
    }

    public boolean allMatchAge(Stream<Student> studentStream, int age) {
        return studentStream.allMatch(s -> s.age() == age);
    }

    public boolean noneMatchKor(Stream<Student> studentStream, int kor) {
        return studentStream.noneMatch(s -> s.kor() == kor);
    }

    public Optional<Student> findFirst(Stream<Student> studentStream) {
        return studentStream.findFirst();
    }
}
