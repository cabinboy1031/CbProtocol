package xyz.mysticcabin.CbLib.Protocol.CbProtocol.test;

import xyz.mysticcabin.CbLib.Protocol.CbProtocol.Connection;
import xyz.mysticcabin.CbLib.Protocol.CbProtocol.StringMessage;
import xyz.mysticcabin.CbLib.Protocol.CbProtocol.Protocol;

import java.io.*;

public class AppServer {
    public static void main(String[] args) throws IOException {
        Connection server = Protocol.connect(400, ConnectionImpl::new);

        System.out.println(server.recieve().getData());
        server.send(new StringMessage("I LOVE YOU TOO RANDOM CITIZEN."));
    }
}
