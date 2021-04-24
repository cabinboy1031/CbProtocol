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
    public int send(Message message){
        StringMessage data = (StringMessage) message;
        try {
            System.out.println("Sending message:\n"
                    + data.getData());

            StringMessage packedMessage = (StringMessage) data.pack();
            String[] output = packedMessage.getData().split("\n");
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
    public StringMessage recieve() {
        try {
            System.out.print("Waiting for message...");
            StringBuilder input = new StringBuilder();

            String line = "";
            while(!line.equals(StringMessage.FOOTER)) {
                line = inputStream.readUTF();
                input.append(line).append("\n");
            }

            StringMessage data = new StringMessage(input.toString());
            System.out.println("done.");
            return (StringMessage) data.unpack();
        } catch (IOException e) {
            System.err.println("Connection closed before read.");
            return new StringMessage("");
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
