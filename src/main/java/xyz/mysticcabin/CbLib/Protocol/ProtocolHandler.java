package xyz.mysticcabin.CbLib.Protocol;

import xyz.mysticcabin.CbLib.Protocol.CbProtocol.Message;

import java.io.IOException;

public interface ProtocolHandler {
    int send(Message message) throws IOException;
    Message recieve();

    void close();
}
