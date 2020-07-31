package remote.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Женя on 18.07.2017.
 */
public interface ServiceServer extends Remote {

    Object[] getServiceList() throws RemoteException;

    Service getService(Object serviceKey) throws RemoteException;
}
