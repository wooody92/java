package dev.effective.java.chapter3.item11;

import java.util.Objects;

public class Sample {

    private String name;
    private int age;

    public Sample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sample sample = (Sample) o;
        return age == sample.age &&
            Objects.equals(name, sample.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
