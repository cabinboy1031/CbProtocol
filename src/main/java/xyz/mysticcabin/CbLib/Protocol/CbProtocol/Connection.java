package xyz.mysticcabin.CbLib.Protocol.CbProtocol;

import java.io.IOException;

public interface Connection {
    int send(Message message) throws IOException;
    Message recieve();

    void close();
}
