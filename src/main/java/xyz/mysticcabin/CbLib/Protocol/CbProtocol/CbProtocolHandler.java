package xyz.mysticcabin.CbLib.Protocol.CbProtocol;

import xyz.mysticcabin.CbLib.Protocol.ProtocolHandler;

import java.io.*;
import java.net.Socket;

public class CbProtocolHandler implements ProtocolHandler {
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Socket socket;

    public CbProtocolHandler(Socket socket) {
        this.socket = socket;
        try {
            this.outputStream = new DataOutputStream(socket.getOutputStream());
            this.inputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public <T> int send(IMessage<T> message){
        try {
            System.out.println("Sending message:\n"
                    + message);

            String packedMessage = message.pack();
            String[] output = packedMessage.split("\n");
            for(String line : output){
                outputStream.writeUTF(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return 500;
        }
        return 200;
    }

    @Override
    public <T> Message<T> receive() {
        try {
            System.out.print("Waiting for message...");
            StringBuilder input = new StringBuilder();

            String line = "";
            while(!line.equals(IMessage.FOOTER)) {
                line = inputStream.readUTF();
                input.append(line).append("\n");
            }


            System.out.println("done.");
            return new Message<>(input.toString());
        } catch (IOException e) {
            System.err.println("Connection closed before read.");
            return null;
        }
    }

    @Override
    public void close(){
        try {
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
