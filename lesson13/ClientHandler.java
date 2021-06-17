package geek.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Olga Shestakova
 * Date 17.06.2021
 */
public class ClientHandler {

    private Server server; // ссылка на сервер
    private Socket socket; //клиент запоминает socket
    private String username; //имя пользователя с кем общаемся
    private DataInputStream in; // клиент запоминает входящий и
    private DataOutputStream out; // исходящий потоки

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream()); // потоки данных, входящий
            this.out = new DataOutputStream(socket.getOutputStream()); // потоки данных, исходящий
            new Thread(() -> {
                try {

                    while (true) {
                        String inputMessage = in.readUTF(); // авторизация, бессконечный цикл, ждем сообщение пользователя
                        if (inputMessage.startsWith("/auth ")){
                        username = inputMessage.split("\\s+", 2)[1]; //запрос от клиента имя пользователя
                            sendMessage("/authok " + username);
                            sendMessage("Вы зашли в чат под именим: " + username);
                            server.subscribe(this);
                        break;
                        }else {
                            sendMessage("Server: Вам необходимо авторизоваться");
                        }
                    }
                    while (true) {
                        String inputMessage = in.readUTF(); // общение, бессконечный цикл, ждем сообщение пользователя
                        if (inputMessage.startsWith("/")){
                            continue;
                        }
                        server.broadcastMessage(username + ": " + inputMessage); //широковещательная рассылка
                    }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
                    server.unsubscribe(this); //исключить из цикла рассылки
                }
        }).start();
    }catch (IOException e){
        e.printStackTrace();
            }
        }
        public void sendMessage(String message){ //общение с конкретным пользователям
        try {
            out.writeUTF(message);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
