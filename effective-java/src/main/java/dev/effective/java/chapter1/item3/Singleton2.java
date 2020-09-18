package dev.effective.java.chapter1.item3;

public class Singleton2 {

    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2() {
        if (INSTANCE != null) {
            throw new RuntimeException("THIS IS SINGLETON CLASS");
        }
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
