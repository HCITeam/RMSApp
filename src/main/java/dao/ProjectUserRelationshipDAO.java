package dao;

import entity.ProjectUserRelationship;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectUserRelationshipDAO extends BaseDAO<ProjectUserRelationship> {
    public List<ProjectUserRelationship> findProjectUserRelationshipByProject(int projectID) ;
  
    public List<ProjectUserRelationship> findProjectUserRelationshipByUser(int userID) ;
    public ProjectUserRelationship findProjectUserRelationshipByID(int id);
}
