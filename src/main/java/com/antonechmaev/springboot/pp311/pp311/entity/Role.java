package com.antonechmaev.springboot.pp311.pp311.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="role")
    private String role;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    @Transient
    private Set<User> users;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public void addUserToRole(User user) {
        if(users==null){
            users = new HashSet<User>();
        }
        users.add(user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String getAuthority() {
        return getRole();
    }
}
