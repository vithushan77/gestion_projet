package com.green.gestion_projet.models.entities;

import com.green.gestion_projet.interfaces.IVisitor;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@XmlRootElement
public class Task extends BaseEntity{

    private String name;

    private String description;

    private Project project;

    private String projectId;

    private TaskStatus status;

    private LocalDateTime dueDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private User asigneTo;

    private String asigneToId;


    public Task(String name, String description, Project project, TaskStatus status, LocalDateTime dueDate, User asigneTo) {
        this.name = name;
        this.description = description;
        this.project = project;
        this.status = status;
        this.dueDate = dueDate;
        this.asigneTo = asigneTo;
    }

    public Task() {
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
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

    public User getAsigneTo() {
        return asigneTo;
    }

    public void setAsigneTo(User asigneTo) {
        this.asigneTo = asigneTo;
    }

    public String getAsigneToId() {
        return asigneToId;
    }

    public void setAsigneToId(String asigneToId) {
        this.asigneToId = asigneToId;
    }

    public String toString(){
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", projectId='" + projectId + '\'' +
                ", status='" + status + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", asigneToId='" + asigneToId + '\'' +
                '}';
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

}
