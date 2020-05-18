package fr.rgautr01.client;

import java.io.*;
import java.net.Socket;

public class Client {

    static final String ADDRESS = "127.0.0.1";
    static final int PORT = 8001;

    public static void main(String[] args) {

        Socket socket = null;

        try {

            socket = new Socket(ADDRESS, PORT);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            dataOutputStream.writeUTF("ping");

            while (socket.isConnected()){

                String data = dataInputStream.readUTF();

                System.out.println(data);

                socket.close();

            }

        } catch(Exception e){
            e.printStackTrace();
        }

    }

}
