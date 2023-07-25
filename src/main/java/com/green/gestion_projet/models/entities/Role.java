package com.green.gestion_projet.models.entities;

import com.green.gestion_projet.interfaces.IVisitor;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class Role extends BaseEntity {
    private String name;
    private List<User> users;

    public Role(String name){
        this.name = name;
    }

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void accept(IVisitor visitor){
        visitor.visit(this);
    }
}
