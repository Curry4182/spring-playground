package com.gorani.springplayground.java.stream.model;

import com.gorani.springplayground.java.stream.enums.ProductType;
import lombok.Builder;

@Builder
public record Product (
        String name,
        int price,
        int quantity,
        ProductType type
) {
}
