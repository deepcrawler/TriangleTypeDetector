package com.company;

import app.triangleApp;
import org.junit.runner.JUnitCore;
import simpleioc.iocContainer;
import test.triangleTestPrimer;
import triangle.ItriangleDetector;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        //For testing
        JUnitCore.runClasses(triangleTestPrimer.class);
        //For manual use
//        try(var scope=triangleApp.beginScope()){
//            ItriangleDetector detector= scope.getService(ItriangleDetector.class);
//            var res=detector.detect(3,5,7);
//            System.out.println("detected Triangle Type is:"+res);
//        }
//        catch(Exception ex){
//
//        }
    }

    public  interface  itest
    {
        void testMethod();
    }

    public static class  testCl implements  itest
    {

        @Override
        public void testMethod() {
            System.out.println("test method1212");
        }
    }
}


