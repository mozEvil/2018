package remote.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Женя on 17.07.2017.
 */
public interface MyRemoteInterface extends Remote {

    String sayHello() throws RemoteException;

}
