# CbProtocol
A VERY naiive implementation of a basic JSON protocol in java.

## Basic usage
```
__BEGIN_MSG__
{ "example": "Any json data can work as long as there is an associated object to it" }
__END_MSG__
```

```java
class JsonObject {
  String example;
  
  public String getExample(){
    return example;
  }
}

public class App {
  public static void main(){
    Connection client = Protocol.connect("localhost",PORT);
    System.out.println(client.recieve(JsonObject.class).getExample());
  }
}
```

Only really meant for me specifically. 
its supposed to work with sockets in order for C++ projects to interact with any data i want accessed from java.

It uses the GSON library to send and recieve json objects, the end goal is to pass an object into a message class and the message will format itself without extra effort.

NOTE: Any rules for sending and recieving data are the same as serializing/deserializing with the GSON library. This really cant be changed due to the fact that i wanted a plaintext interface, just keep in mind if you compose a class that makes use of references to other classes, or more importantly a circular reference.
