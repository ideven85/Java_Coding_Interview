package com.cleo.shop.domain;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car extends Product{

    private int horsePower;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return true;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
