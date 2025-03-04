package com.nghiasoftware.demojpa08.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "users")
public class Users {

    /**
     * @Id: id là khóa chính
     * @GeneratedValue(strategy = GenerationType.IDENTITY): id tự động tăng
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "users")
    private List<UsersRoles> usersRoles;

    public List<UsersRoles> getUsersRoles() {
        return usersRoles;
    }

    public void setUsersRoles(List<UsersRoles> usersRoles) {
        this.usersRoles = usersRoles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
