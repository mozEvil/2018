package remote.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Женя on 17.07.2017.
 */
public class MyRemoteClass extends UnicastRemoteObject implements MyRemoteInterface {

    protected MyRemoteClass() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Сервер говорит: 'Привет'";
    }

    public static void main(String[] args) {
        try {
            MyRemoteInterface myRemoteService = new MyRemoteClass();
            Naming.rebind("hello", myRemoteService);

        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
