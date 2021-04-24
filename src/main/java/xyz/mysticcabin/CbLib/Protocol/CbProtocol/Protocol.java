package xyz.mysticcabin.CbLib.Protocol.CbProtocol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Protocol {
    public static Connection connect(String host, int port,
                                     ProtocolActor fun) throws IOException {
        Socket socket;
        System.out.print("Waiting for server...");
        socket = new Socket(host, port);
        System.out.println("done");


        return fun.run(socket);
    }

    public static Connection connect(int port,
                                     ProtocolActor fun) throws IOException{
        Socket socket;
        ServerSocket serverSocket;

        System.out.println("Starting server.");
        serverSocket = new ServerSocket(port);
        System.out.print("Getting client address...");
        socket = serverSocket.accept();
        System.out.println("done.");

        return fun.run(socket);
    }
}
