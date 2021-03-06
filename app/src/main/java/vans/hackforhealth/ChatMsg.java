package vans.hackforhealth;

/**
 * Created by root on 8/4/17.
 */

public class ChatMsg {

    String sender;
    String receiver;
    String data;
    long timestamp;
    String key;

    public ChatMsg(){}

    public ChatMsg(String sender, String receiver, String data, long timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.data = data;
        this.timestamp = timestamp;
        this.key = "";
    }


    public boolean isMine() {
        return true;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(sender==null?"null ":sender+" ");
        b.append(receiver ==null?"null ": receiver +" ");
        b.append(data==null?"null ":data+" ");
        return b.toString();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}