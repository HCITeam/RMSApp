package dao.impl;

import dao.ProjectUserRelationshipDAO;
import entity.ProjectUserRelationship;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
@Repository
public class ProjectUserRelationshipDAOImpl extends BaseDAOImpl<ProjectUserRelationship> implements ProjectUserRelationshipDAO{
    
    @Override
    public List<ProjectUserRelationship> findProjectUserRelationshipByProject(int projectID) {
       return  getListByColumn("projectId",projectID);
       
    }
    
    @Override
    public List<ProjectUserRelationship> findProjectUserRelationshipByUser(int userID) {
        return getListByColumn("userId",userID);
       
    }
    
    @Override
    public ProjectUserRelationship findProjectUserRelationshipByID(int id) {
        return getByColumn("id",id);
    }
    
}
