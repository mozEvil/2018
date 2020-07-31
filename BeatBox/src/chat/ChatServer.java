package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Женя on 16.07.2017.
 */
public class ChatServer {

    private ArrayList<PrintWriter> clientOutputStreams;

    public static void main(String[] args) {
        new ChatServer().go();
    }

    public void go() {
        clientOutputStreams = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientOutputStreams.add(new PrintWriter(clientSocket.getOutputStream()));
                new Thread(() -> thread_ClientHandler(clientSocket)).start();
                System.out.println("got a connection");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void thread_ClientHandler(Socket clientSocket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("read " + message);
                tellEveryone(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void tellEveryone(String message) {
        for (PrintWriter writer : clientOutputStreams) {
            writer.println(message);
            writer.flush();
        }
    }
}
