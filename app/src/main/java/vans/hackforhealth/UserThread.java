package vans.hackforhealth;

import java.util.ArrayList;

/**
 * Created by anind on 4/7/2017.
 * For a new user thread view on the recycler view.
 */

public class UserThread {
    public String name;
    public ArrayList<String> tags;
    public String body;

    public UserThread() {}

    public UserThread(String name, ArrayList<String> tags, String body) {
        this.name = name;
        this.tags = tags;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public String getBody() {
        return body;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder(name);
        builder.append(" "+tags);
        builder.append(" "+body);
        return builder.toString();
    }
}
