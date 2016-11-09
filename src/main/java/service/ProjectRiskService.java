package service;

import entity.ProjectRisk;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectRiskService {
    /**
     * 新增风险
     * @param projectRisk
     * @return
     */
    public ProjectRisk addProjectRisk(ProjectRisk projectRisk);

    /**
     * 删除风险
     * @param projectRisk
     * @return
     */
    public boolean deleteProjectRisk(ProjectRisk projectRisk);

    /**
     * 更新风险信息
     * @param projectRisk
     * @return
     */
    public boolean updateProjectRisk(ProjectRisk projectRisk);

    /**
     * 查询某个项目的所有风险
     * @param projectID
     * @return
     */
    public List<ProjectRisk> findProjectRiskByProject(int projectID);

    /**
     * 查询具体某一个风险
     * @param id
     * @return
     */
    public ProjectRisk findProjectRiskByID(int id);
}
