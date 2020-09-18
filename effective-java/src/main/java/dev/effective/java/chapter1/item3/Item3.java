package dev.effective.java.chapter1.item3;

public class Item3 {

    public static void main(String[] args) {
        singletonTest1();
    }

    public static void singletonTest1() {
        Singleton1 singleton1 = Singleton1.INSTANCE;
        Singleton1 singleton2 = Singleton1.INSTANCE;
        System.out.println(singleton1.equals(singleton2)); // true
    }
}
