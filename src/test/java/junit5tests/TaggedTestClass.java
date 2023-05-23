package junit5tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaggedTestClass {

    @BeforeAll
    void printBeforeAll(){
        System.out.println("This method set ups environment before all tests.");
    }

    @BeforeEach
    void printBeforeEach(){
        System.out.println("--before each method");
    }

    @Test
    @Tag("sanity")
    void firstMethod(){
        System.out.println("This is the first test method.");
    }

    @Test
    @Tag("sanity")
    @Tag("acceptance")
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
    @Tag("acceptance")
    void thirdMethod(){
        System.out.println("This is the third test method");
    }

    @Tag("acceptance")
    @ParameterizedTest(name="Run: {index} - value: {arguments}")
    @ValueSource(ints={1,5,6})
    void intValues(int theParam){
        System.out.println("theParam = " + theParam);
    }
}
