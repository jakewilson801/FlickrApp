package com.jakewilson.flickr;

/**
 * Created by jakewilson on 3/12/14.
 */
public class Item {

    private int id;
    private String title;
    private String secret;
    private String url;
    private String name;
    private String location;
    private Long date;

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Item(int id, String title, String secret, String url, Long date, String name){
        this.id = id;
        this.title = title;
        this.secret = secret;
        this.url = url;
        this.date = date;
        this.name = name;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
