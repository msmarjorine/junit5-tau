package junit5tests;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void assertEqualsTest(){
        assertEquals("firstString", "secondString", "The string values were not equal");
    }

    @Test
    void asserEqualsListTest(){
        List<String> expectedValues = asList("firstString", "secondString", "thirdString");
        List<String> actualValues = asList("firstString", "secondString", "thirdString");
        assertEquals(expectedValues, actualValues);
    }

    @Test
    void assertArraysEqualsTest(){
        int[] expectedValues = {1,2,3};
        int[] actualValues = {1,2,3};
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void assertTrueTest(){
        assertFalse(false);
        assertTrue(false, "This boolean condition did not evaluate to true");
    }

    @Test
    void assertThrowsTest(){
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest(){
        assertAll(
                () -> assertEquals("firstString", "secondString", "The string values were not equal"),
                () -> assertThrows(NullPointerException.class, null),
                () -> assertTrue(false, "This boolean condition did not evaluate to true")
        );
    }

    @Test
    void assertForMapTest(){
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

        assertThat(theMap, Matchers.hasKey("secondKey"));
        assertThat(theMap, Matchers.hasValue(3));
    }

    @Test
    void assertForListTest(){
        List<String> theList = asList("firstString", "secondString", "thirdString");

        assertThat(theList, hasItem("thirdString"));
    }

    @Test //doesn't work ??
    void assertForAnyOfTest(){
        List<String> theList = asList("firstString", "secondString", "thirdString");

        assertThat(theList, anyOf(hasItem("thirdString"),
                hasItem("fourthString")));
    }

    @Test //doesn't work ??
    void assertForContainsAnyOrder(){
        List<String> theList = asList("firstString", "secondString", "thirdString");

        assertThat(theList, containsInAnyOrder("firstString", "secondString", "thirdString"));
    }
}
