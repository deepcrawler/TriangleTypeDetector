package test;

import app.triangleApp;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import simpleioc.serviceProvider;
import triangle.ItriangleDetector;
import triangle.triangleType;

import java.util.concurrent.ThreadLocalRandom;

public abstract class baseTriangleTest {
    serviceProvider scope=null;
    @Before
    public void BeforeTest()
    {
        scope= triangleApp.beginScope();
    }
    @After
    public void AfterTest()
    {
        try {
            if (scope != null)
                scope.close();
        }
        catch (Exception ex)
        {
            System.out.println("Exception:" +ex.getMessage());
            ex.printStackTrace();
        }
    }

    protected void checkTriangle(int a, int b, int c, triangleType expectedtt){
        var res = getTriangleDetector().detect(a, b, c);
        printTriangle(a, b, c, res);
        Assert.assertTrue(res == expectedtt);
    }
    protected int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private void printTriangle(int a, int b, int c, triangleType tt){
        System.out.printf("Run triangle detctor with %d,%d,%d sides, detected triangle type is %s %n",a,b,c,tt);
    }
    private ItriangleDetector getTriangleDetector(){
        try {
            return scope.getService(ItriangleDetector.class);
        } catch (Exception e) {
            System.out.println("Exception:" +e.getMessage());
            e.printStackTrace();
            return  null;
        }
    }

}
