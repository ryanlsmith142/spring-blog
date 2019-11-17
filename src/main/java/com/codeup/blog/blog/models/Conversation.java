package com.codeup.blog.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conversations")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, columnDefinition = "int(11) UNSIGNED")
    private long id;

    @Column(nullable=false)
    private long primary_user;

    @Column(nullable=false)
    private long secondary_user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_conversation",
            joinColumns = {@JoinColumn(name = "conversation_id")},
            inverseJoinColumns = {@JoinColumn(name="user_id")}

    )
    private List<User> users;

    public Conversation() {}

    public Conversation(long primary_user, long secondary_user) {
        this.primary_user = primary_user;
        this.secondary_user = secondary_user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrimary_user() {
        return primary_user;
    }

    public void setPrimary_user(long primary_user) {
        this.primary_user = primary_user;
    }

    public long getSecondary_user() {
        return secondary_user;
    }

    public void setSecondary_user(long secondary_user) {
        this.secondary_user = secondary_user;
    }
}
