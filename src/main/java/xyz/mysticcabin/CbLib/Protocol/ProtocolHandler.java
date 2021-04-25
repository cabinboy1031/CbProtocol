package xyz.mysticcabin.CbLib.Protocol;

import xyz.mysticcabin.CbLib.Protocol.CbProtocol.IMessage;

import java.io.IOException;

public interface ProtocolHandler {
    <T> int send(IMessage<T> message) throws IOException;
    <T> IMessage<T> receive();

    void close();
}
