package se.johnwilander.typing;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @johnwilander
 */
public class StrongTypingTest {
    @Test
    public void addTest() {
        int intVar = 10;
        int[] intArray = {0};
        assertEquals((intVar + ""), "10");  // Implicit typecast
//        assertEquals((intVar + null), 10);  // Not allowed
        assertEquals((intVar + 0.0), 10.0);  // Widening implicit typecast
        assertEquals((intVar + (int)0.0), 10);  // Widening implicit typecast
//        assertEquals((intVar + true), 5);  // Not allowed
//        assertEquals((intVar + intArray), "10");  // Not allowed

    }
}
