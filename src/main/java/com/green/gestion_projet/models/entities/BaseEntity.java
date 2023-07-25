package com.green.gestion_projet.models.entities;

import com.green.gestion_projet.interfaces.IVisitable;
import com.green.gestion_projet.interfaces.IVisitor;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class BaseEntity implements IVisitable {
    protected String id;

    public BaseEntity() {
    }
    public BaseEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        this.id = id;
    }
}
