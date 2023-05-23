package junit5tests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass2 {

    @BeforeAll
    void printBeforeAll(){
        System.out.println("This method set ups environment before all tests.");
    }

    @BeforeEach
    void printBeforeEach(){
        System.out.println("--before each method");
    }

    @Test
    @Order(2)
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

    @Test
    @Order(1)
    void thirdTest(){
        System.out.println("This is the third test method");
    }
}
