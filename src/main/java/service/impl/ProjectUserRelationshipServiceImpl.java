package service.impl;

import dao.ProjectUserRelationshipDAO;
import entity.ProjectUserRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ProjectUserRelationshipService;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
@Service
@Transactional
public class ProjectUserRelationshipServiceImpl implements ProjectUserRelationshipService {
    
    @Autowired
    private ProjectUserRelationshipDAO projectUserRelationshipDAO;
    
    @Override
    public ProjectUserRelationship addProjectUserRelationship(ProjectUserRelationship projectUserRelationship) {
        projectUserRelationshipDAO.add(projectUserRelationship);
        return (ProjectUserRelationship)projectUserRelationshipDAO.getNewAddedEntity();
    }
    
    @Override
    public boolean deleteProjectUserRelationship(ProjectUserRelationship projectUserRelationship) {
        projectUserRelationshipDAO.delete(projectUserRelationship);
        return true;
    }
    
    @Override
    public List<ProjectUserRelationship> findProjectUserRelationshipByProject(int projectID) {
        return projectUserRelationshipDAO.findProjectUserRelationshipByProject(projectID);
        
    }
    
    @Override
    public List<ProjectUserRelationship> findProjectUserRelationshipByUser(int userID) {
         return projectUserRelationshipDAO.findProjectUserRelationshipByUser(userID);
        
    }
    
    @Override
    public ProjectUserRelationship findProjectUserRelationshipByID(int id){
        return projectUserRelationshipDAO.findProjectUserRelationshipByID(id);
    }
}
