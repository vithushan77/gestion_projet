package com.green.gestion_projet.interfaces;


import javafx.collections.ObservableList;

public interface IHierarchicalItem {
    String getId();

    String getName();

    String getIconLiteral();

    void onClick();

    IHierarchicalItem getParent();

    ObservableList<IHierarchicalItem> getChildren();
}
