package com.green.gestion_projet.interfaces;

import javafx.scene.Node;

@FunctionalInterface
public interface IContentLoadedCallback {
    void onContentLoaded(Node content);
}