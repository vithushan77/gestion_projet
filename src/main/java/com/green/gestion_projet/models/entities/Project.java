package com.green.gestion_projet.models.entities;

import com.green.gestion_projet.interfaces.IVisitor;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDateTime;
import java.util.List;

@XmlRootElement
public class Project extends BaseEntity {

    private String name;
    private String description;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    private List<Task> tasks;
    private List<User> users;

    public Project(String id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt, List<Task> tasks, List<User> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.tasks = tasks;
        this.users = users;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Project() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "TaskStatus{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
