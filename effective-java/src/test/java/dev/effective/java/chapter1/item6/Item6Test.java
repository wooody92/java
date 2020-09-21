package dev.effective.java.chapter1.item6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Item6Test {

    @Test
    public void stringReference() {
        String a = new String("test");
        String b = "test";
        String c = "test";

        assertNotSame(a, b);
        assertNotSame(a, c);
        assertSame(b, c);
    }
}