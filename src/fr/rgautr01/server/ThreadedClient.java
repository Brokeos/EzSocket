package fr.rgautr01.server;

import java.io.*;
import java.net.Socket;

public class ThreadedClient extends Thread
{

    private Socket socket;

    public ThreadedClient(Socket socket){
        this.socket = socket;
    }

    public void run(){

        System.out.println("New client on " + socket.getLocalPort());

        if (socket.isConnected()){

            DataInputStream dataInputStream = null;
            DataOutputStream dataOutputStream = null;

            try {

                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                while (socket.isConnected()){

                    String data = dataInputStream.readUTF();

                    System.out.println(data);

                    dataOutputStream.writeUTF("pong");
                    dataOutputStream.flush();

                }

            } catch (Exception e){
                e.printStackTrace();
            }

        }

    }

}
