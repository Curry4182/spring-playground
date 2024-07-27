package com.gorani.springplayground.java.stream.model;

import lombok.Builder;

@Builder
public record User(
        String name,
        int age,
        String email
) {

    public User(String name) {
        this(name, 0, "");
    }
}
