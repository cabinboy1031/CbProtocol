package xyz.mysticcabin.CbLib.Protocol.CbProtocol;

import com.google.gson.Gson;

public class Message<T> implements IMessage<T> {
    T data;
    String jsonData;

    public Message(String jsonData){
        this.jsonData = jsonData;
    }

    public Message(T objectData){
        this.data = objectData;
    }

    @Override
    public String pack() {
        Gson gson = new Gson();

        String jsonString = gson.toJson(this.data);

        return HEADER + "\n"
                + jsonString + "\n"
                + FOOTER;
    }

    @Override
    public T unpack(Class<T> type) {
        Gson gson = new Gson();
        String[] parsedData = jsonData.split("\n");
        StringBuilder finalData = new StringBuilder();

        for(int i = 1; i < parsedData.length - 1; i++){
            if(!parsedData[i].equals(HEADER) || !parsedData[i].equals(FOOTER)) {
                finalData.append(parsedData[i]).append("\n");
            } else {
                // TODO empty because bug? If statement has issues if no else.
            }
        }

        return gson.fromJson(finalData.toString(), type);
    }
}
