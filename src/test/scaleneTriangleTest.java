package test;

import org.junit.Test;
import triangle.triangleType;

public class scaleneTriangleTest extends baseTriangleTest {
    @Test
    public void scaleneTriangle_Random() {
        int min = 1;
        int max = 100;

        for (int i = min; i <= max; i++) {
            int ar = getRandomInt(min, max);
            int br = 0;
            int cr = 0;
            while (ar <= Math.abs(br - cr) || ar >= br + cr) {
                ar = getRandomInt(min, max);
                while (br == ar || br==0)
                    br = getRandomInt(min, max);
                while (cr == br || cr == ar || cr==0)
                    cr = getRandomInt(min, max);
            }
            checkTriangle(ar, br, cr,triangleType.scalene);
        }
    }
}
