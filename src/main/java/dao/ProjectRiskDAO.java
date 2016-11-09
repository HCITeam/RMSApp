package dao;

import entity.ProjectRisk;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectRiskDAO extends BaseDAO<ProjectRisk> {
    /**
     * 项目id查询
     * @param projectID
     * @return
     */
    public List<ProjectRisk> findProjectRiskByProject(int projectID);

    /**
     * 风险id查询
     * @param id
     * @return
     */
    public ProjectRisk findProjectRiskByID(int id);
}
