package models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(as = Book.class)
public abstract class Item implements Serializable {

    private String id;
    private String title;
    private String location;

    private Map<String, Object> tags;

    public Item() {

    }

    public Item(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
        tags = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    @Override
    public String toString() {
        return "\n\t\tmodels.Item\n\t\t{\n" +
                "\t\t\tid='" + id + "\'," + '\n' +
                "\t\t\ttitle='" + title + "\'," + '\n' +
                "\t\t\tlocation='" + location + "\'," + '\n' +
                "\t\t\ttags=" + tags + '\n' +
                "\t\t}";
    }
}