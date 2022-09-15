package brique.problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {

    private int count;
    private Socket socket;
    private Scanner scanner;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;

    public static void main(String[] args) {
        Client client = new Client();
        client.on();
    }

    public void on() {
        try {
            init();
            doWhileMessageIsClose();
            close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        socket = new Socket("127.0.0.1", 8081);
        scanner = new Scanner(System.in);
        printWriter = new PrintWriter(socket.getOutputStream());
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private void doWhileMessageIsClose() throws IOException {
        while (true) {
            String inputMessage = getInputMessage();

            if (inputMessage.equals("close")) {
                break;
            }

            sendMessage(inputMessage);
            receiveMessage();
            increaseCount();
        }
    }

    private String getInputMessage() {
        return scanner.next();
    }

    private void sendMessage(String msg) {
        printWriter.println(msg);
        printWriter.flush();
        System.out.println("Send(" + count + "):" + msg);
    }

    private void receiveMessage() throws IOException {
        String msg = bufferedReader.readLine();
        System.out.println("Receive(" + count + "):"  + msg);
    }

    private void increaseCount() {
        count++;
    }

    private void close() throws IOException {
        bufferedReader.close();
        printWriter.close();
        scanner.close();
        socket.close();
    }
}
