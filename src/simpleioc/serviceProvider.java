package simpleioc;

import java.lang.reflect.InvocationTargetException;
import java.rmi.activation.Activator;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class serviceProvider implements AutoCloseable {
    private UUID guid;
    ConcurrentHashMap<Class, Object> coll = null;
    iocContainer ioc = null;
    public serviceProvider(UUID guid, iocContainer iOC)
    {
        this.guid = guid;
        this.ioc = iOC;
        this.coll = new ConcurrentHashMap<Class, Object>();
    }
    public <T> T getService(Class tint) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (coll.containsKey(tint))
            return (T)coll.get(tint);
        else
        {
            var type = ioc.getImpClass(tint);

            T obj=(T)type.getConstructor(null).newInstance(null);
            coll.putIfAbsent(tint, obj);
            return (T)obj;
        }
    }

    @Override
    public void close() throws Exception {
        if (coll != null)
        {
            for (var item : Collections.list(coll.elements()))
            {
                if(item instanceof AutoCloseable)
                    ((AutoCloseable)item).close();
            }
        }
        ioc.removeScope(guid);
    }
}
