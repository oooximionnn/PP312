package com.antonechmaev.springboot.pp311.pp311.entity;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="role")
    private String role;
}
