package junit5tests;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestClass {

    @BeforeAll
    void printBeforeAll(){
        System.out.println("This method set ups environment before all tests.");
    }

    @BeforeEach
    void printBeforeEach(){
        System.out.println("--before each method");
    }

    @Test
    void firstMethod(){
        System.out.println("This is the first test method.");
    }

    @Test
    @DisplayName("US1234 - TC12 - this method is the second one")
    void secondMethod(){
        System.out.println("This is the second test method.");
    }

    @AfterEach
    void printAfterEach(){
        System.out.println("--after each method");
    }

    @AfterAll
    void printAfterAll(){
        System.out.println("This method cleans environment after all tests.");
    }
}
