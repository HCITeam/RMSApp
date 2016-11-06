package dao;

import entity.ProjectRisk;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectRiskDAO extends BaseDAO<ProjectRisk> {
    public List<ProjectRisk> findProjectRiskByProject(int projectID);
    public ProjectRisk findProjectRiskByID(int id);
}
