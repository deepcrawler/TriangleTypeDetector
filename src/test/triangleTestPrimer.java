package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        invalidTriangleTest.class,
        equilateralTriangleTest.class,
        isoscelesTriangleTest.class,
        boundariesTriangleTest.class
})
public class triangleTestPrimer {

}
