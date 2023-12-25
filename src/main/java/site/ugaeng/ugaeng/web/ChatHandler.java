package site.ugaeng.ugaeng.web;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatHandler {

    @OnOpen
    public void handleOpen() {
        System.out.println("new connection opened");
    }

    @OnMessage
    public String handleMessage(String message) {

        System.out.println("receive from client : " + message);

        String replyMessage = "echo " + message;
        System.out.println("send to client : " + replyMessage);

        return replyMessage;
    }

    @OnClose
    public void handleClose() {
        System.out.println("connection closed");
    }

    @OnError
    public void handleError() {
        System.err.println("error occurred");
    }
}
