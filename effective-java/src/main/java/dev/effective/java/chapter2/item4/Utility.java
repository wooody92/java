package dev.effective.java.chapter2.item4;

public class Utility {

    // instance 생성 방지
    private Utility() {
        throw new AssertionError();
    }

    public static final String name = "Henry";
}
