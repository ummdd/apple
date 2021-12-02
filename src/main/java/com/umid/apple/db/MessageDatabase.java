package com.umid.apple.db;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class MessageDatabase {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String text;

    @Column(name = "tutti")
    private String tag;

    public MessageDatabase(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public MessageDatabase(){ }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}