package remote.client;

import remote.server.MyRemoteInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Женя on 17.07.2017.
 */
public class MyRemoteClient {

    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    private void go() {
        try {
            MyRemoteInterface myRemoteService = (MyRemoteInterface) Naming.lookup("rmi://127.0.0.1/hello");
            String s = myRemoteService.sayHello();
            System.out.println(s);

        } catch (NotBoundException | RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
