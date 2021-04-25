package xyz.mysticcabin.CbLib.Protocol.CbProtocol.test;

import xyz.mysticcabin.CbLib.Protocol.CbProtocol.CbProtocolHandler;
import xyz.mysticcabin.CbLib.Protocol.CbProtocol.IMessage;
import xyz.mysticcabin.CbLib.Protocol.CbProtocol.Message;
import xyz.mysticcabin.CbLib.Protocol.ProtocolHandler;
import xyz.mysticcabin.CbLib.Protocol.Protocol;

import java.io.IOException;
import java.lang.reflect.Member;

public class AppClient {
    public static void main(String[] args) throws IOException {
        ProtocolHandler client = Protocol.connect("localhost",400, CbProtocolHandler::new);

        client.send(new Message<>(new StringWrapper("Hello world!\nfuck you god\n__END_MSG__\n")));

        //TODO Make a single function
        IMessage<StringWrapper> message = client.receive();
        StringWrapper data = (StringWrapper) message.unpack(StringWrapper.class);

        System.out.println(data.message);
    }
}
