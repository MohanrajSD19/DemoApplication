package com.unittesting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        //assertEquals(4, 2 + 2);
        MyClass myClass = new MyClass();
        int result = myClass.add(2, 2);
        int expected = 4;
        assertEquals(expected, result);
    }
}