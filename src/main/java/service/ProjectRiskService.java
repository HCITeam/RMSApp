package service;

import entity.ProjectRisk;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectRiskService {
    public boolean addProjectRisk(ProjectRisk projectRisk);
    public boolean deleteProjectRisk(ProjectRisk projectRisk);
    public boolean updateProjectRisk(ProjectRisk projectRisk);
    public List<ProjectRisk> findProjectRiskByProject(int projectID);
    public ProjectRisk findProjectRiskByID(int id);
}
