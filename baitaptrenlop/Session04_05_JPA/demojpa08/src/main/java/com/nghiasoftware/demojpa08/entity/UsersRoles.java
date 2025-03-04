package com.nghiasoftware.demojpa08.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nghiasoftware.demojpa08.entity.keys.UsersRolesId;
import jakarta.persistence.*;

@Entity(name = "users_roles")
public class UsersRoles {

    @EmbeddedId
    private UsersRolesId id;

    /**
     * Bảng nào giữ khóa ngoại sẽ là @ManyToOne và @JoinColumn
     * Nhớ là entity được tham chiếu khóa ngoại phải map ngược lại @OneToMany
     */

    @ManyToOne
    @JoinColumn(name = "roles_id", insertable = false, updatable = false)
    private Roles roles;

    @ManyToOne
    @JoinColumn(name = "users_id", insertable = false, updatable = false)
    private Users users;

    public UsersRolesId getId() {
        return id;
    }

    public void setId(UsersRolesId id) {
        this.id = id;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
