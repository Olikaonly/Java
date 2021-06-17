package geek.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga Shestakova
 * Date 17.06.2021
 */
public class Server {
    private List<ClientHandler>clients;// лист подключившихся

    public Server(){
        try {
            this.clients = new ArrayList<>();
            ServerSocket serverSocket = new ServerSocket(8189); // создание сервера для подключения
            System.out.println("Сервер запущен. Ожидание...");
            while (true) {
                Socket socket = serverSocket.accept(); //ждем подключения (блок операция)
                System.out.println("Подключился новый пользователь");
                ClientHandler c = new ClientHandler(this,socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public synchronized void subscribe(ClientHandler c){ // подписатся на рассылку
        clients.add(c);
    }
    public synchronized void unsubscribe(ClientHandler c){// отподписатся от рассылки
        clients.remove(c);
    }
    public synchronized void broadcastMessage(String message){ // широковещательная рассылка
        for (ClientHandler c : clients){
            c.sendMessage(message);
        }
    }
}
