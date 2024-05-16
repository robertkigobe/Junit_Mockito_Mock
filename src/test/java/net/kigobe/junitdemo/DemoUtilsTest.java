package net.kigobe.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
class DemoUtilsTest {
    DemoUtils demoUtils;
    @BeforeAll
    static void setupBeforeAlltests() {
        System.out.println("@Before all Running at the beginning of all tests\n");
    }

    @AfterAll
    static void tearDownAfterAllTests() {
        System.out.println("@after all Running after all tests");

    }

    @BeforeEach
    void setupBeforeEach() {
        //Setup
        System.out.println("@Before each test");
        demoUtils = new DemoUtils();
    }

    @AfterEach
    void tearDownAfterEach() {
        System.out.println("@AfterEach test");
        System.out.println();
    }

    @Test
    @DisplayName("Equals and Not Equals")
    void testEqualsNotEquals() {
        //Execute and assert
        System.out.println("Running test: testEqualsNotEquals");
        assertEquals(6, demoUtils.add(2, 4), "2+4 must equal 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must equal 6");
    }

    @Test@DisplayName("Multiplication")
    void testMultiply(){
        assertEquals(12, demoUtils.multiply(4,3), "4*3 must be 12");
    }

    @Test
    @DisplayName("Null and Not Null")
    void checkNullNotNull() {
        //Execute and Assert
        System.out.println("Running test: checkNullNotNull");
        String str1 = null;
        String str2 = "Kigobe";
        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @Test
    @DisplayName("Same and Not Same")
    void testSameAndNotSame() {
        //Execute and Assert
        String str1 = "luv2code";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
        assertNotSame(str1, demoUtils.getAcademy(), "Objects should not refer to same object");
    }

    @Test
    @DisplayName("Test true or false")
    void testEquality() {
        //Execute and Assert
        int gradeone = 10;
        int gradetwo = 5;
        assertTrue(demoUtils.isGreater(gradeone, gradetwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradetwo, gradeone), "This should return false");
    }

    @DisplayName("Array Equals")
    @Test
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "D"};
        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");
    }

    @DisplayName("Iterable equals")
    @Test
    void testIterableEquals() {
        List<String> theList = List.of("luv", "2", "code");
        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be same as actual list");
    }

    @DisplayName("Lines match")
    @Test
    void testLinesMatch() {
        List<String> theList = List.of("luv", "2", "code");
        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
    }

    @DisplayName("Throws and Does Not Throw")
    @Test
    void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, () -> { demoUtils.throwException(-1); }, "Should throw exception");
        assertDoesNotThrow(() -> { demoUtils.throwException(5); }, "Should not throw exception");

    }

    @DisplayName("Timeout")
    @Test
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> { demoUtils.checkTimeout(); },
                "Method should execute in 3 seconds");
    }
}
