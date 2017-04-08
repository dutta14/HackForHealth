package vans.hackforhealth;

/**
 * Created by root on 8/4/17.
 */

public class ChatMsg {

    String Sender;
    String Reciver;
    String Body;
    long timestamp;

    public ChatMsg(){

    }

    public ChatMsg(String sender, String reciver, String body, long timestamp) {
        Sender = sender;
        Reciver = reciver;
        Body = body;
        this.timestamp = timestamp;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getReciver() {
        return Reciver;
    }

    public void setReciver(String reciver) {
        Reciver = reciver;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
