package dev.effective.java.chapter3.item11;

public class Item11 {

    public static void main(String[] args) {
        Sample sample1 = new Sample("A", 1);
        Sample sample2 = new Sample("A", 1);

        // hashcode
        System.out.println(sample1.hashCode());
        System.out.println(sample2.hashCode());

        // result
        System.out.println(sample1.equals(sample2));
        System.out.println(sample1 == sample2);
    }
}
