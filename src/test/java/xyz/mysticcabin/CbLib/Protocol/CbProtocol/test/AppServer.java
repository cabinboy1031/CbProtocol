package xyz.mysticcabin.CbLib.Protocol.CbProtocol.test;

import xyz.mysticcabin.CbLib.Protocol.CbProtocol.CbProtocolHandler;
import xyz.mysticcabin.CbLib.Protocol.ProtocolHandler;
import xyz.mysticcabin.CbLib.Protocol.CbProtocol.StringMessage;
import xyz.mysticcabin.CbLib.Protocol.Protocol;

import java.io.*;

public class AppServer {
    public static void main(String[] args) throws IOException {
        ProtocolHandler server = Protocol.connect(400, CbProtocolHandler::new);

        System.out.println(server.recieve().getData());
        server.send(new StringMessage("I LOVE YOU TOO RANDOM CITIZEN."));
    }
}
