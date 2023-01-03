package net.kigobe.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach(){

        System.out.println("@Before each test");
        demoUtils = new DemoUtils();
    }

    @AfterEach
    void tearDownAfterEach(){
        System.out.println("@AfterEach test");
        System.out.println();
    }

    @BeforeAll
    static void setupBeforeAlltests(){
        System.out.println("@Before all Running at the beginning of all tests\n");
    }

    @AfterAll
    static void tearDownAfterAllTests(){
        System.out.println("@after all Running after all tests");
    }
    @Test
    @DisplayName("Equals and Not Equals")
    void testEqualsNotEquals(){

        System.out.println("Running test: testEqualsNotEquals");
        DemoUtils demoUtils = new DemoUtils();

        assertEquals(6, demoUtils.add(2,4), "2+4 must equal 6");
        assertNotEquals(6, demoUtils.add(1,9), "1+9 must equal 6");
    }

    @Test
    @DisplayName("Null and Not Null")
    void checkNullNotNull(){

        System.out.println("Running test: checkNullNotNull");

        DemoUtils demoUtils = new DemoUtils();
        String str1 = null;
        String str2 = "Kigobe";
        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @Test
    @DisplayName("Same and Not Same")
    void testSameAndNotSame(){
        String str1 = "luv2code";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
        assertNotSame(str1, demoUtils.getAcademy(), "Objects should not refer to same object");
    }

    @Test
    @DisplayName("Test true or false")
    void testEquality(){
        int gradeone = 10;
        int gradetwo = 5;

        assertTrue(demoUtils.isGreater(gradeone, gradetwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradetwo, gradeone), "This should return false");
    }
}
