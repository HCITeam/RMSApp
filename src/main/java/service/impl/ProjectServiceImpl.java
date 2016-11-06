package service.impl;

import dao.ProjectDAO;
import entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import service.ProjectService;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public class ProjectServiceImpl implements ProjectService {
    
    @Autowired
    private ProjectDAO projectDAO;
    
    @Override
    public boolean addProject(Project project) {
        projectDAO.add(project);
        return true;
    }
    
    @Override
    public boolean deleteProject(Project project) {
        projectDAO.delete(project);
        return true;
    }
    
    @Override
    public boolean updateProject(Project project) {
        projectDAO.update(project);
        return true;
    }
    
    @Override
    public Project findProjectByID(int id) {
        
        return projectDAO.getByColumn("id",id);
    }
    
    @Override
    public List<Project> findProjectByCreater(String creater) {
        
        return projectDAO.getListByColumn("creater",creater);
    }
}
