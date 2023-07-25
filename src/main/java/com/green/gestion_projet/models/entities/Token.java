package com.green.gestion_projet.models.entities;
import com.green.gestion_projet.interfaces.IVisitor;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;

@XmlRootElement
public class Token extends BaseEntity{

    private String token;

    private String context;

    private LocalDate createdAT;
    private LocalDate updatedAT;

    private User user;

    private String userId;

    public Token() {
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
