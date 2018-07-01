package test;

import org.junit.Test;
import triangle.triangleType;

public class isoscelesTriangleTest extends baseTriangleTest {
    @Test
    public void isoscelesTriangle_Random() {
        int a=100;
        int min=a/2+1;
        int max=a-1;

        for (int i = min; i <=max ; i++) {
            int randomNum = getRandomInt(min, max);
            checkTriangle(a, randomNum, randomNum,triangleType.isosceles);
        }
    }
}
