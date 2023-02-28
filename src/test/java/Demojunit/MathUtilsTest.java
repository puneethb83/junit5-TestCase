package Demojunit;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

	MathUtils mathUtils;
	
//	@BeforeAll
//	void beforeallinit() {
//		System.out.println("This cases need to run before all");
//	}
//	
//	@AfterAll
//	 void afterallinit() {
//		System.out.println("This cases need to clean after all");
//	}
	
	
    @BeforeEach
	void init() { // ->create a method void in it
      mathUtils = new MathUtils();

	}
    
//    @AfterEach
//    void cleanup() {
//    	System.out.println("cleaning up...");
//    }

    @Nested
    @DisplayName("add method")
    class AddTest{
    	
  
	@Test
	@DisplayName("Adding two positive numbers")
	void testAddPositive() {
		//int expected = 3;
		//int actual = mathUtils.add(2, 1);
		assertEquals(3,mathUtils.add(2, 1), "Should return the right sum");

	}
	
	@Test
	@DisplayName("Adding two negative numbers")
	void testAddNegative() {
		//int expected = -3;
		//int actual = mathUtils.add(-2, -1);
		assertEquals(-3,mathUtils.add(-2,-1), "should return the right sum");
	}
	
	@Test
	@DisplayName("multiply methods")
	void testMultiply() {
		//assertEquals(4,mathUtils.multiply(2,2), "should return the right product");
		
		assertAll(
				() -> assertEquals(4, mathUtils.multiply(2,2)),
				() -> assertEquals(0, mathUtils.multiply(2,0)),
				() -> assertEquals(-4, mathUtils.multiply(-2,2))
				);
			
		
	}
	
	

	@Test
	@EnabledOnOs(OS.LINUX)
	void testdivide() {
		
		boolean isServerUp=false;
		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero throws Exception");

	}

	@Test
	void ComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.ComputeCircleArea(10), "should return right circle area");
	}
	
	@Test
	@Disabled
	@DisplayName("TDD method. Should not run")
	void testdisabled() {
		fail("this test should be disabled");
	}

}
}
