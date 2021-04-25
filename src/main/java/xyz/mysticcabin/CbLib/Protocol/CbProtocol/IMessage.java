package xyz.mysticcabin.CbLib.Protocol.CbProtocol;

public interface IMessage<T> {
    String HEADER = "__BEGIN_MSG__";
    String FOOTER = "__END_MSG__";
    /**
     * @return a Message object formatted into JSON and packed into message headers.
     */
    String pack();

    /**
     * @return a Message that contains an Object
     */
    Object unpack(Class<T> type);
}
