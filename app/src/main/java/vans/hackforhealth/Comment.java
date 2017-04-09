package vans.hackforhealth;

import java.util.Date;

/**
 * Created by anind on 4/9/2017.
 */

public class Comment {
    public String threadId, userId, message;
    public long timestamp;

    public Comment() {}

    public Comment(String threadId, String userId, String message) {
        this.threadId = threadId;
        this.userId = userId;
        this.message = message;
        this.timestamp = new Date().getTime();
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
