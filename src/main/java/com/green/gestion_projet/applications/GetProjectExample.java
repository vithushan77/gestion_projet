package com.green.gestion_projet.applications;

import com.green.gestion_projet.models.entities.Project;
import com.green.gestion_projet.services.ProjectService;

public class GetProjectExample {

    private static ProjectService projectService = new ProjectService();

    public static void main(String[] args) {
        Project[] projects = projectService.getAll();
        System.out.println("All Projects: " + projects);
    }

}
