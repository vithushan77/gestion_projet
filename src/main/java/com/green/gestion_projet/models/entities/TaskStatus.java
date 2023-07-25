package com.green.gestion_projet.models.entities;
import com.green.gestion_projet.interfaces.IVisitor;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
import java.util.Locale;
import java.time.LocalDateTime;
import java.util.Objects;

@XmlRootElement
public class TaskStatus extends BaseEntity{

    private String name;

    private List<Task> tasks;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public TaskStatus() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
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

    @Override
    public String toString(){
        return "TaskStatus{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
    @Override
    public void accept(IVisitor visitor){
        visitor.visit(this);
    }
}
