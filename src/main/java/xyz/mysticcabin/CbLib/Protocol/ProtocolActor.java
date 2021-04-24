package xyz.mysticcabin.CbLib.Protocol;

import java.net.Socket;

public interface ProtocolActor {
    ProtocolHandler run(Socket socket);
}
