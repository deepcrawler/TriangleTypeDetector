package test;

import org.junit.Test;
import triangle.triangleType;

public class invalidTriangleTest extends baseTriangleTest {
    @Test
    public void invalidTriangle_LittleSide() {
        int a=50;
        int b=30;
        for(int c=1;c<=a-b;c++) {
            checkTriangle(a, b, c,triangleType.invalid);
        }
    }

    @Test
    public void invalidTriangle_LargeSide() {
        int a=50;
        int b=30;
        for(int c=a+b;c<=(a+b)+ 10 ;c++) {
            checkTriangle(a, b, c,triangleType.invalid);
        }
    }

    @Test
    public void invalidTriangle_NegativeOrZeroSide() {
        int a=50;
        int b=30;
        for(int c=0;c>=(a-b)- b ;c--) {
            checkTriangle(a, b, c,triangleType.invalid);
        }
    }
}
