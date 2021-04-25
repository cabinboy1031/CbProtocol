package xyz.mysticcabin.CbLib.Protocol.CbProtocol.test;

import xyz.mysticcabin.CbLib.Protocol.CbProtocol.CbProtocolHandler;
import xyz.mysticcabin.CbLib.Protocol.CbProtocol.IMessage;
import xyz.mysticcabin.CbLib.Protocol.CbProtocol.Message;
import xyz.mysticcabin.CbLib.Protocol.ProtocolHandler;
import xyz.mysticcabin.CbLib.Protocol.Protocol;

import java.io.*;

public class AppServer {
    public static void main(String[] args) throws IOException {
        ProtocolHandler server = Protocol.connect(400, CbProtocolHandler::new);

        //TODO turn this into a function or put this into an existing function;
        IMessage<StringWrapper> message = server.receive(StringWrapper.class);
        StringWrapper data = (StringWrapper) message.unpack(StringWrapper.class);

        System.out.println(data.message);
        server.send(new Message<>(new StringWrapper("I LOVE YOU TOO RANDOM CITIZEN.")));
    }
}
