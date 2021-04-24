package xyz.mysticcabin.CbLib.Protocol.CbProtocol.test;

import xyz.mysticcabin.CbLib.Protocol.CbProtocol.Connection;
import xyz.mysticcabin.CbLib.Protocol.CbProtocol.Protocol;
import xyz.mysticcabin.CbLib.Protocol.CbProtocol.StringMessage;

import java.io.IOException;

public class AppClient {
    public static void main(String[] args) throws IOException {
        Connection client = Protocol.connect("localhost",400,
                (socket) -> new ConnectionImpl().setup(socket));

        client.send(new StringMessage("Hello world!\nfuck you god\n__END_MSG__\n"));
        System.out.println(client.recieve().getData());

    }
}
