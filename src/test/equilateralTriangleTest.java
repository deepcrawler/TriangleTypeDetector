package test;

import org.junit.Test;
import triangle.triangleType;

public class equilateralTriangleTest extends baseTriangleTest {
    @Test
    public void equilateralTriangle_Random() {
        int min=1;
        int max=100;
        for (int i = min; i <=max ; i++) {
            int randomNum = getRandomInt(min, max);
            checkTriangle(randomNum, randomNum, randomNum,triangleType.equilateral);
        }
    }
}
