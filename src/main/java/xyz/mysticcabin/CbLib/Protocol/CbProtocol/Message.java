package xyz.mysticcabin.CbLib.Protocol.CbProtocol;

public interface Message {
    /**
     * @return a Message object that contains the same data but with the required headers.
     */
    Message pack();

    /**
     * @return a Message object that contains the same data without the headers.
     */
    Message unpack();

    Object getData();
}
