package geek.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Olga Shestakova
 * Date 16.06.2021
 */
public class ServerApp {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен. Ожидание...");

            Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Клиент подключился");
            while (true) {
                String inputMessage = in.readUTF();
                System.out.println(inputMessage);
                out.writeUTF("ECHO: " + inputMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
