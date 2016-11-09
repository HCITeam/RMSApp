package dao;

import entity.ProjectUserRelationship;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectUserRelationshipDAO extends BaseDAO<ProjectUserRelationship> {
    /**
     * 项目id查询
     * @param projectID
     * @return
     */
    public List<ProjectUserRelationship> findProjectUserRelationshipByProject(int projectID) ;

    /**
     * 用户id查询
     * @param userID
     * @return
     */
    public List<ProjectUserRelationship> findProjectUserRelationshipByUser(int userID) ;

    /**
     * 本身id查询
     * @param id
     * @return
     */
    public ProjectUserRelationship findProjectUserRelationshipByID(int id);

    /**
     * 双id查询
     * @param projectId
     * @param userId
     * @return
     */
    public ProjectUserRelationship findProjectUserRelationshipByUserAndProject(int projectId,int userId);
}
