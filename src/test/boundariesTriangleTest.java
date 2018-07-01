package test;

import org.junit.Test;
import triangle.triangleType;

public class boundariesTriangleTest extends baseTriangleTest {
    @Test
    public void equilateralTriangle_MaxInteger() {
        int a=Integer.MAX_VALUE;
        checkTriangle(a, a, a,triangleType.equilateral);
    }
    @Test
    public void isoscelesTriangle_MaxInteger() {
        int a=Integer.MAX_VALUE;
        checkTriangle(a, a, a-1,triangleType.isosceles);
    }
    @Test
    public void scaleneTriangle_MaxInteger() {
        int a=Integer.MAX_VALUE;
        checkTriangle(a-2, a, a-1,triangleType.scalene);
    }
    @Test
    public void InvalidTriangle_MaxInteger() {
        int a=Integer.MAX_VALUE+1; //Overflow
        checkTriangle(a, a, a,triangleType.invalid);
    }

    @Test
    public void InvalidTriangle_ZeroInteger() {
        int a=0;
        checkTriangle(a, a+1, a+2,triangleType.invalid);
    }
}
