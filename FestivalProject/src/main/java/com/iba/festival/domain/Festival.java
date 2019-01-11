package com.iba.festival.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Festival {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String title;
    private String text;
    private String type;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    @ManyToMany
    @JoinTable(
            name = "fest_user",
            joinColumns = { @JoinColumn(name = "fest_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id")}
    )
    private Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "fest_user",
            joinColumns = { @JoinColumn(name = "fest_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id")}
    )
    private Set<User> speakers = new HashSet<>();

    public Festival(){    }

    public Festival(String title, String text, String type, String tag, User user) {
        this.title = title;
        this.text = text;
        this.type = type;
        this.tag = tag;
        this.author = user;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<User> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Set<User> speakers) {
        this.speakers = speakers;
    }

}
