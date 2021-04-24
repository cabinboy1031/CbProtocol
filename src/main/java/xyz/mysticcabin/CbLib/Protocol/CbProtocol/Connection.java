package xyz.mysticcabin.CbLib.Protocol.CbProtocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public interface Connection {
    int send(Message message) throws IOException;
    Message recieve();

    void close();
}
