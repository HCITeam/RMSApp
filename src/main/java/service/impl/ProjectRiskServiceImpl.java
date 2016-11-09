package service.impl;

import dao.ProjectRiskDAO;
import entity.ProjectRisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ProjectRiskService;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
@Service
@Transactional
public class ProjectRiskServiceImpl implements ProjectRiskService {
    
    @Autowired
    private  ProjectRiskDAO projectRiskDAO;
    
    @Override
    public ProjectRisk addProjectRisk(ProjectRisk projectRisk) {
         projectRiskDAO.add(projectRisk);
        return (ProjectRisk)projectRiskDAO.getNewAddedEntity();
    }
    
    @Override
    public boolean deleteProjectRisk(ProjectRisk projectRisk) {
        projectRiskDAO.delete(projectRisk);
        return true;
    }
    
    @Override
    public boolean updateProjectRisk(ProjectRisk projectRisk) {
        projectRiskDAO.update(projectRisk);
        return true;
    }
    
    @Override
    public List<ProjectRisk> findProjectRiskByProject(int projectID) {
        return projectRiskDAO.findProjectRiskByProject(projectID);
    }
    
    @Override
    public ProjectRisk findProjectRiskByID(int id) {
        return projectRiskDAO.findProjectRiskByID(id);
    }
}
