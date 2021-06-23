package ru.geekbrains.june.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<ClientHandler> clients;

    public Server() {
        try {
            this.clients = new ArrayList<>();
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен. Ожидаем подключение клиентов..");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Подключился новый клиент");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void subscribe(ClientHandler c) {
        broadcastMessage("В чат зашел пользователь " + c.getUsername()); //сообщение что кто то зашел в чат
        clients.add(c);
        broadcastClientList();
    }

    public synchronized void unsubscribe(ClientHandler c) {
        clients.remove(c);
        broadcastMessage("Из чата вышел пользователь " + c.getUsername()); // //сообщение что кто то вышел из чата
        broadcastClientList();
    }

    public synchronized void broadcastMessage(String message) {
        for (ClientHandler c : clients) {
            c.sendMessage(message);
        }
    }

    public synchronized void broadcastClientList() { // сбор рассылка имен пользователей
        StringBuilder builder = new StringBuilder(clients.size() * 10);
        builder.append("/clients_list ");
        for (ClientHandler c : clients) {
            builder.append(c.getUsername()).append(" ");
        }
        String clientsListStr = builder.toString();
        broadcastMessage(clientsListStr);
    }

    public synchronized boolean isUsernameUsed(String username) { //проверка на занятость имени пользователя
        for (ClientHandler c : clients) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

            //метод для отправки личного сообщения
    public synchronized void sendPersonalMessage(ClientHandler sender, String receiverUsername, String message) {
        if (sender.getUsername().equalsIgnoreCase(receiverUsername)) { // запрет на отправку лич. сообщений самому себе
            sender.sendMessage("Нельзя отправлять личные сообщения самому себе");
            return;
        }
        for (ClientHandler c : clients) {
            if (c.getUsername().equalsIgnoreCase(receiverUsername)) {
                c.sendMessage("от " + sender.getUsername() + ": " + message); //сообщение получателю
                sender.sendMessage("пользователю " + receiverUsername + ": " + message); //сообщение автору
                return;
            }
        }
        sender.sendMessage("Пользователь " + receiverUsername + " не в сети"); //сообщение автору
    }
}
