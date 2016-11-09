package service;

import entity.Project;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectService {
    /**
     * 新增项目
     * @param project
     * @return
     */
    public Project addProject(Project project);

    /**
     * 删除项目
     * @param project
     * @return
     */
    public boolean deleteProject(Project project);

    /**
     * 更新项目
     * @param project
     * @return
     */
    public boolean updateProject(Project project);

    /**
     * 查询某个项目
     * @param id
     * @return
     */
    public Project findProjectByID(int id);

    /**
     * 根据用户查询项目
     * @param creater
     * @return
     */
    public List<Project> findProjectByCreater(int creater);
}
