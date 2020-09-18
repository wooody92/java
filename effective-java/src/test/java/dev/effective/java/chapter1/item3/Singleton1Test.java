package dev.effective.java.chapter1.item3;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;

class Singleton1Test {

    @Test
    public void singletonTest1()
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton1 singleton1 = Singleton1.INSTANCE;
        Singleton1 singleton2 = Singleton1.INSTANCE;

        Constructor<Singleton1> constructor = (Constructor<Singleton1>) singleton2.getClass()
            .getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton1 singleton3 = constructor.newInstance();

        assertEquals(singleton2, singleton3);
    }
}