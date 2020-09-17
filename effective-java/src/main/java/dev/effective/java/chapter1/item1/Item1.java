package dev.effective.java.chapter1.item1;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item1 {

    private String name;
    private String email;

    @Builder
    public Item1(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static Item1 of(String name, String email) {
        return Item1.builder()
            .name(name)
            .email(email)
            .build();
    }
}
