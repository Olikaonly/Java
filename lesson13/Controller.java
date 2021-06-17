package geek.chat.client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    TextArea chatArea; //многострочное текстовое поле

    @FXML
    TextField messageField, usernameField; // однострочное текстовое поле

    @FXML
    HBox authPanel, msgPanel;

    private Socket socket; // соеденение с сервером
    private DataInputStream in;  //входящий поток
    private DataOutputStream out; //искходящий поток

    public void sendMessage() { //отправка сообщений на сервер
        try {
            out.writeUTF(messageField.getText());
            messageField.clear();
            messageField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void tryToAuth() { //авторизация
        connect();
        try {
            out.writeUTF("/auth " + usernameField.getText());
            usernameField.clear();
        } catch (IOException e) {
            showError("Не возможно отправить запрос авторизации на сервер");
        }

    }
    public void connect(){ // попытка подключится

        if (socket != null && !socket.isClosed()){
            return;
        }
        try {
            socket = new Socket("localhost", 8189); //подключение к серверу
            in = new DataInputStream(socket.getInputStream()); // входящий поток
            out = new DataOutputStream(socket.getOutputStream()); //исходящий поток
            Thread readThread = new Thread(() -> {
                try {
                    while (true) { // бессконечный цикл, ждем сообщения, отдельный поток
                        String inputMessage = in.readUTF();
                        if(inputMessage.startsWith("/authok ")){
                            msgPanel.setVisible(true); //показываем
                            msgPanel.setManaged(true); //показываем
                            authPanel.setVisible(false); //прячем
                            authPanel.setManaged(false); //прячем
                            break;
                        }
                        chatArea.appendText(inputMessage + "\n");
                    }
                    while (true) { // бессконечный цикл, ждем сообщения, отдельный поток
                        String inputMessage = in.readUTF();
                        chatArea.appendText(inputMessage + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readThread.start();
        } catch (IOException e) {
            showError("Невозможно подключиться к серверу");
            System.exit(0);
        }
    }
    public void showError(String message){
      new Alert(Alert.AlertType.ERROR, message, ButtonType.OK).showAndWait();
    }
}
