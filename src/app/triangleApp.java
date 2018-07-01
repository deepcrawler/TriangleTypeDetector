package app;

import simpleioc.iocContainer;
import simpleioc.serviceProvider;
import triangle.ItriangleDetector;
import triangle.triangleDetector;

public class triangleApp {
    private static boolean iocRegistered = false;

    private static iocContainer getIOC()
    {
        if(!iocRegistered) {
            var ioc=iocContainer.getInstance();
             ioc.register(ItriangleDetector.class, triangleDetector.class);
             //
            iocRegistered=true;
        }
        //
        return iocContainer.getInstance();
    }

    public static serviceProvider beginScope()
    {
        return getIOC().beginScope();
    }
}
