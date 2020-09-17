package dev.effective.java.chapter1.item1;

public interface TestInterface {

    void print();

    static void getLowerType() {
        TestExtendClass testExtendClass = new TestExtendClass();
        testExtendClass.print();
    }
}
