package dev.effective.java.chapter1.item4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilityTest {

    @Test
    public void instanceTest() {
//        Utility utility1 = new Utility();
//        Utility utility2 = new Utility();
//        assertEquals(false, utility1.equals(utility2));
    }

    @Test
    public void instanceTest2() {
        AbstractUtility utility1 = new ExtendUtility();
        AbstractUtility utility2 = new ExtendUtility();
        assertEquals(false, utility1.equals(utility2));
    }
}