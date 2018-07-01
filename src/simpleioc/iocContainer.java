package simpleioc;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class iocContainer {
    private ConcurrentHashMap<Class, Class> IOCStore = null;
    private ConcurrentHashMap<UUID, serviceProvider> IOCColl = null;

    static iocContainer instance = null;
    static Object locker = new Object();
    public static iocContainer getInstance()
    {
        synchronized (locker)
        {
            if (instance == null)
                instance = new iocContainer();
            return instance;
        }
    }

    public iocContainer()
    {
        IOCStore = new ConcurrentHashMap<Class, Class>();
        IOCColl = new ConcurrentHashMap<UUID, serviceProvider>();
    }
    public Class getImpClass(Class t)
    {
        return IOCStore.get(t);
    }

    public void register(Class tint,Class timp)
    {
        IOCStore.put(tint,timp);
    }

    public serviceProvider beginScope()
    {
        UUID guid = UUID.randomUUID();
        var sp = new serviceProvider(guid, this);
        IOCColl.putIfAbsent(guid, sp);
        return sp;
    }
    public void removeScope(UUID guid)
    {
        serviceProvider ignore;
        IOCColl.remove(guid);
    }
}
