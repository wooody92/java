package dev.effective.java.chapter2.item7;

import lombok.Getter;

@Getter
public class Food {

    private String name;

    public Food(String name) {
        this.name = name;
    }
}
