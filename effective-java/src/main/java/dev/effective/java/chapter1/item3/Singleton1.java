package dev.effective.java.chapter1.item3;

public class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
        if (INSTANCE != null) {
            throw new RuntimeException("THIS IS SINGLETON CLASS");
        }
    }
}
