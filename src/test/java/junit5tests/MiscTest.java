package junit5tests;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class MiscTest {

    @Test
    //@Timeout(value=5, unit = TimeUnit.MINUTES)
    @Timeout(5)
    void timeout() throws InterruptedException {
        System.out.println("This is the test with the timeout");
        Thread.sleep(4000);
    }

    @Test
    @Timeout(90)
    @DisplayName("This is the nice method")
    @Tag("theTag")
    void annotatedMethod1(){
        System.out.println("This is the annotated method");
    }


    @MyAnnotation
    void annotatedMethod2(){
        System.out.println("This is the custom annotated method");
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTest{

        @BeforeAll
        void beforeAll(){
            System.out.println("Before All in nested test method");
        }

        @Test
        void nestedTestMethod(){
            System.out.println("Nested test method");
        }
    }
}
