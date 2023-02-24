package Demojunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void test() {
		MathUtils mathUtils=new MathUtils();
		int expected=3;
		float actual=mathUtils.add(2, 1);
		assertEquals(expected, actual);

	}

}
