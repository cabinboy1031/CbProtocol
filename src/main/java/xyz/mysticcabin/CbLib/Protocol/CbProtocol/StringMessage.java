package xyz.mysticcabin.CbLib.Protocol.CbProtocol;

import com.google.gson.Gson;

import java.util.Arrays;

public class StringMessage implements Message {
    public static final String HEADER = "__MSG_BEGIN__";
    class StringObject {
        String message;
        public StringObject(String message){
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    StringObject data;
    public static final String FOOTER = "__MSG_END__";

    public StringMessage(String message){
        this.data = new StringObject(message);
    }

    @Override
    public Message pack() {
        Gson gson = new Gson();

        String jsonString = gson.toJson(this.data);
        String newData = HEADER + "\n"
                + jsonString + "\n"
                + FOOTER;

        return new StringMessage(newData);
    }

    @Override
    public Message unpack() {
        Gson gson = new Gson();
        String[] parsedData = data.getMessage().split("\n");
        StringBuilder finalData = new StringBuilder();

        for(int i = 1; i < parsedData.length - 1; i++){
            if(!parsedData[i].equals(HEADER) || !parsedData[i].equals(FOOTER)) {
                finalData.append(parsedData[i]).append("\n");
            } else {
                // TODO empty because bug? If statement has issues if no else.
            }
        }
        StringObject tempObject = gson.fromJson(finalData.toString(),StringObject.class);

        return new StringMessage(tempObject.getMessage());
    }

    @Override
    public String getData() {
        return data.getMessage();
    }
}
