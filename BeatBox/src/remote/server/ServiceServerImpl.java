package remote.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * Created by Женя on 18.07.2017.
 */
public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer  {

    private HashMap serviceList;

    protected ServiceServerImpl() throws RemoteException {
        setUpServices();
    }

    private void setUpServices() {
        serviceList = new HashMap();
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Day of the Week Service", new DayOfTheWeekService());
        serviceList.put("Visual Music Service", new MiniMusicService());
    }

    @Override
    public Object[] getServiceList() throws RemoteException {
        System.out.println("in remote");
        return serviceList.keySet().toArray();
    }

    @Override
    public Service getService(Object serviceKey) throws RemoteException {
        return (Service) serviceList.get(serviceKey);
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("ServiceServer", new ServiceServerImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Remote service is running");
    }
}
