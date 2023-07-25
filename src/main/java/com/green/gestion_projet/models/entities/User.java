package com.green.gestion_projet.models.entities;
import com.green.gestion_projet.interfaces.IVisitor;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@XmlRootElement
public class User extends BaseEntity{
    private String email;

    private String password;

    private String firstName;
    private String lastName;
    private String passwordHash;

    private String username;

    private Role role;
    private Project project;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<Task> asignedTasks;

    private List<Task> createdTasks;

    private List<Token> tokens;



    public User(String email, String firstName, String lastName) {
        this.id= UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();


        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.asignedTasks= List.of();
        this.createdTasks= List.of();
        this.tokens= List.of();
    }

    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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

    public List<Task> getAsignedTasks() {
        return asignedTasks;
    }

    public void setAsignedTasks(List<Task> asignedTasks) {
        this.asignedTasks = asignedTasks;
    }

    public List<Task> getCreatedTasks() {
        return createdTasks;
    }

    public void setCreatedTasks(List<Task> createdTasks) {
        this.createdTasks = createdTasks;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString(){
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", passwordHash=" + passwordHash +
                ", username=" + username +
                ", role=" + role +
                ", project=" + project +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", asignedTasks=" + asignedTasks +
                ", createdTasks=" + createdTasks +
                ", tokens=" + tokens +
                '}';
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
