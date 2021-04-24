package xyz.mysticcabin.CbLib.Protocol.CbProtocol;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public interface ProtocolActor {
    Connection run(Socket socket);
}
