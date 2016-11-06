package service;

import entity.ProjectUserRelationship;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectUserRelationshipService {
    public boolean addProjectUserRelationship(ProjectUserRelationship projectUserRelationship);
    public boolean deleteProjectUserRelationship(ProjectUserRelationship projectUserRelationship);
    public List<ProjectUserRelationship> findProjectUserRelationshipByProject(int projectID);
    public List<ProjectUserRelationship> findProjectUserRelationshipByUser(int userID);
    public ProjectUserRelationship findProjectUserRelationshipByID(int id);
}
