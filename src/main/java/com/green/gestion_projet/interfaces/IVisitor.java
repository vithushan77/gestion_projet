package com.green.gestion_projet.interfaces;

import com.green.gestion_projet.models.entities.*;

public interface IVisitor {

    void visit(User user);
    void visit(Project project);
    void visit(Role role);
    void visit(Task task);
    void visit(TaskStatus taskStatus);
    void visit(Token token);

}
