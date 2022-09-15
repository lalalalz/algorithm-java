package brique.problem2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int count;
    private Socket clientSocket;
    private ServerSocket serverSocket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;

    public static void main(String[] args) {
        Server server = new Server();
        server.on();
    }

    public void on() {
        try {
            init();
            doWhileClientConnected();
            close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        serverSocket = new ServerSocket(8081);
        clientSocket = serverSocket.accept();

        count = 0;
        printWriter = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        printInitMessage();
    }

    private void printInitMessage() {
        String remoteAddress = clientSocket
                .getRemoteSocketAddress()
                .toString();

        String host = remoteAddress.substring(1, remoteAddress.indexOf(":"));
        String port = remoteAddress.substring(remoteAddress.indexOf(":") + 1, remoteAddress.length());

        System.out.println("Connected by('" + host + "', " + port + ")");
    }

    private void doWhileClientConnected() throws IOException {
        while (true) {
            String receivedMessage = receiveMessage();

            if (receivedMessage == null) {
                break;
            }

            sendMessage(receivedMessage);
            increaseCount();
        }
    }

    private String receiveMessage() throws IOException {
        String msg = bufferedReader.readLine();
        System.out.println("Receive(" + count + "):"  + msg);
        return msg;
    }

    private String sendMessage(String msg) {
        if (msg.equals("Ping")) {
            msg = "Pong";
//            msg.replace(msg, "Pong");
        }

        printWriter.println(msg);
        printWriter.flush();

        System.out.println("Send(" + count + "):" + msg);
        return msg;
    }

    private void increaseCount() {
        count++;
    }

    private void close() throws IOException {
        bufferedReader.close();
        printWriter.close();
        clientSocket.close();
        serverSocket.close();
    }
}
