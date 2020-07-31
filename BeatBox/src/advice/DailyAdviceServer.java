package advice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Женя on 15.07.2017.
 */
public class DailyAdviceServer {

    public static void main(String[] args) {
        new DailyAdviceServer().go();
    }

    String[] adviceList = {
            "Ешьте меньшими порциями.",
            "Купите облегающие джинсы. Нет, они не делают вас полнее.",
            "Два слова: не годится.",
            "Будьте честны хотя бы сегодня. Скажите своему начальнику все, что вы *на самом деле* о нем думаете.",
            "Возможно, вам стоит подобрать другую прическу."};

    public void go() {

        try (ServerSocket serverSocket = new ServerSocket(4242)) {

            while (true) {
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {

        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }
}