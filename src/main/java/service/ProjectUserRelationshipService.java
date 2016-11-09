package service;

import entity.ProjectUserRelationship;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectUserRelationshipService {
    /**
     * 新增项目成员
     * @param projectUserRelationship
     * @return
     */
    public ProjectUserRelationship addProjectUserRelationship(ProjectUserRelationship projectUserRelationship);

    /**
     * 删除项目成员
     * @param projectUserRelationship
     * @return
     */
    public boolean deleteProjectUserRelationship(ProjectUserRelationship projectUserRelationship);

    /**
     * 根据项目id查询
     * @param projectID
     * @return
     */
    public List<ProjectUserRelationship> findProjectUserRelationshipByProject(int projectID);

    /**
     * 根据用户id查询
     * @param userID 用户id
     * @return
     */
    public List<ProjectUserRelationship> findProjectUserRelationshipByUser(int userID);

    /**
     * 自身查询
     * @param id
     * @return
     */
    public ProjectUserRelationship findProjectUserRelationshipByID(int id);
}
