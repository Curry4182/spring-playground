package com.gorani.springplayground.java.stream.basis;

import com.gorani.springplayground.java.stream.model.Student;
import com.gorani.springplayground.java.stream.model.User;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntermediateOperations {

    public Stream<Integer> filterEvenNumbers(Stream<Integer> numbers) {
        return numbers.filter(n -> n % 2 == 0);
    }

    public Stream<Integer> squareNumbers(Stream<Integer> numbers) {
        return numbers.map(n -> n * n);
    }

    public Stream<String>  toUpperCase(Stream<String> strings) {
        return strings.map(String::toUpperCase);
    }

    public Stream<String> getUserNames(Stream<User> users) {
        return users.map(User::name);
    }

    public Stream<Integer> flatMap(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream);
    }

    public OptionalDouble avgScore(List<Student> students) {
        return students.stream()
                .flatMapToInt(s -> IntStream.of(s.kor(), s.eng(), s.math()))
                .average();
    }

    public Stream<Student> sortStudentsByKor(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> s2.kor() - s1.kor());
    }

    public Stream<Integer> skip(List<Integer> numbers, int n) {
        return numbers.stream()
                .skip(n);
    }
}
