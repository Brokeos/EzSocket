package fr.rgautr01.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    static final int PORT = 8001;

    static List<ThreadedClient> clients = new ArrayList<>();

    public static void main(String[] args) {

        ServerSocket serverSocket = null;

        try {

            serverSocket = new ServerSocket(PORT);

            while (!serverSocket.isClosed()){

                Socket socket = serverSocket.accept();
                ThreadedClient threadedClient = new ThreadedClient(socket);

                clients.add(threadedClient);

                threadedClient.start();

            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
