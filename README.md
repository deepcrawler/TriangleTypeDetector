**TriangleDetector**

For a valid triangle with length of sides a, b and c, three equation must be passed:

a < b + c

c < a + b

b < c + a

We can simplify above equations as the following:

|a - b | < c < a + b

If we consider 8 byte integer for storing length of triangle sides, when one of the side has a length greater or equal to 31 ^ 2, memory overflow will be happen. For guarding from this situation we should rewrite equation as the following:

|(long)a - b| < c < (long)a + c

So, with casting a side length to long (16 byte Integer), memory overflow will never happen.
As we know, zero or negative values are not acceptable values for triangle sides, which As you notice, the above equation be able to filer these values.

**Simple IOC (Inversion of Control Container)**

Triangle Detector is a sample which may be extend to broader problems, I wrote Simple IOC for showing this reality that this project could be used as a scalable and larger starter kit for larger problem contexts.

In general, IOC help us to distinguish and separate business declaration from business implementation. 
So, with this architecture, we can simplify replacing a current business implementation with other implementations.

For seeing how to use Simple IOC, please see the usage of ItriangleDetector in the code.

Simple IOC only support Scoped Life time and a scope will be available with running the beginScope method from iocContainer class.
The output of beginScope is an instance of ServiceProvider class. 

In fact, ServiceProvider store the created instances of requested of interfaces by code.
ServiceProvider implements AutoClosable interface so that by the end of a scope, all related used resource can be freed.

Due to use Scoped lift time and ConcurrentHashMap data structure, Parallel usage of Simple IOC is possible and it is definitely a major advantage for using it.

**triangleApp** 

I separated the context domain of Triangle Detector by implementing triangleApp class.

Within this class, SimpleIOC will be initialized and we can get an instance of ServiceProvider by calling beginScope() method.

**Triangle Detector Tests**

Five test suite defined as the five test class which all of them inherited from baseTriangletest:
-	**baseTrianglTest**: it is an abstract class which include before and after codes that must run in each test method ( before and after it). Please see before and after annotations in this class. Also, it has some common methods for triangle detector inherited test classes.
-	**boundariesTriangleTest**: The tests in this class have responsibility for checking boundaries situations. For example when a side have 2^31 value for length or zero value.
-	**equilateralTriangleTest**: The tests in this class, have responsibility for checking the correctness of the Triangle Detector algorithm for identifying equilateral triangles.
-	**isoscelesTriangleTest**: The tests in this class, have responsibility for checking the correctness of the Triangle Detector algorithm for identifying isosceles triangles.
-	**scaleneTriangleTest**: The tests in this class, have responsibility for checking the correctness of the Triangle Detector algorithm for identifying scalene triangles.
-	**invalidTriangleTest**: The tests in this class, have responsibility for checking the correctness of the Triangle Detector algorithm for identifying invalid triangles.
-	**triangleTestPrimer**: It bundles all the test classes which can run by JUnitCore.runclasses method of Junit 4.0 framework.

**How to use from Triangle Detector:**

try(var scope=triangleApp.beginScope()){

    ItriangleDetector detector= scope.getService(ItriangleDetector.class);

    var res=detector.detect(3,5,7);

    System.out.println("detected Triangle Type is:"+res);
}
catch(Exception ex){

}



