package advice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Женя on 15.07.2017.
 */
public class DailyAviceClient {

    public static void main(String[] args) {
        DailyAviceClient client = new DailyAviceClient();
        client.go();
    }

    public void go() {
        try {
            Socket socket = new Socket("127.0.0.1", 4242);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String avice = reader.readLine();
            System.out.println("Сегодня ты должен: " + avice);

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
