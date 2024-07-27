package com.gorani.springplayground.java.stream.model;

import lombok.Builder;

@Builder
public record Student (
        String name,
        int age,
        String email,
        int kor,
        int eng,
        int math
){
}
