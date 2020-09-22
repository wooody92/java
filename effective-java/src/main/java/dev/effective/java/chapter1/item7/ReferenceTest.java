package dev.effective.java.chapter1.item7;

import java.lang.ref.WeakReference;

public class ReferenceTest {

    public static void main(String[] args) {
        Food apple = new Food("apple");

        Food food1 = apple;
        WeakReference<Food> food2 = new WeakReference(apple);

        System.out.println(food1.getName());
        System.out.println(food2.get().getName());

        apple = null;

        System.gc();

        System.out.println(food1.getName());
        System.out.println(food2.get().getName());
    }
}
