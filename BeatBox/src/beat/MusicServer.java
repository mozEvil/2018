package beat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Женя on 16.07.2017.
 */
public class MusicServer {

    private List<ObjectOutputStream> clientOutputStreams;

    public static void main(String[] args) {
        new MusicServer().go();
    }

    private void go() {
        clientOutputStreams = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(4242)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                clientOutputStreams.add(out);

                new Thread(() -> thread_ClientHandler(clientSocket)).start();
                System.out.println("got a connection");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void thread_ClientHandler(Socket clientSocket) {
        try {
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            Object o1, o2;
            while ((o1 = in.readObject()) != null) {
                o2 = in.readObject();
                System.out.println("read two objects");
                tellEveryone(o1, o2);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void tellEveryone(Object o1, Object o2) {
        for (ObjectOutputStream out : clientOutputStreams) {
            try {
                out.writeObject(o1);
                out.writeObject(o2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
