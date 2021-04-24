package xyz.mysticcabin.CbLib.Protocol.CbProtocol.test;

import xyz.mysticcabin.CbLib.Protocol.CbProtocol.CbProtocolHandler;
import xyz.mysticcabin.CbLib.Protocol.ProtocolHandler;
import xyz.mysticcabin.CbLib.Protocol.Protocol;
import xyz.mysticcabin.CbLib.Protocol.CbProtocol.StringMessage;

import java.io.IOException;

public class AppClient {
    public static void main(String[] args) throws IOException {
        ProtocolHandler client = Protocol.connect("localhost",400, CbProtocolHandler::new);

        client.send(new StringMessage("Hello world!\nfuck you god\n__END_MSG__\n"));
        System.out.println(client.recieve().getData());

    }
}
