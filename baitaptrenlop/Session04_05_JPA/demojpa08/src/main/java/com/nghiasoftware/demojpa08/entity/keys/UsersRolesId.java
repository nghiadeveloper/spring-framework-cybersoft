package com.nghiasoftware.demojpa08.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UsersRolesId implements Serializable {

    @Column(name = "roles_id")
    private int roleId;

    @Column(name = "users_id")
    private int userId;

    public UsersRolesId(int roleId, int userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    public UsersRolesId() {}

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
