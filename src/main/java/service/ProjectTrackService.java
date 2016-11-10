package service;

import entity.ProjectTrack;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectTrackService {
    /**
     * 新增跟踪者
     * @param projectTrack
     * @return
     */
    public ProjectTrack addProjectTrack(ProjectTrack projectTrack);

    /**
     * 删除跟踪
     * @param projectTrack
     * @return
     */
    public boolean deleteProjectTrack(ProjectTrack projectTrack);

    /**
     * 更新跟踪
     * @param projectTrack
     * @return
     */
    public boolean updateProjectTrack(ProjectTrack projectTrack);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public  ProjectTrack findProjectTrackByID(int id);

    /**
     * 根据项目id查询
     * @param riskId
     * @return
     */
    public List<ProjectTrack> findProjectTrackByRisk(int riskId);

    /**
     * 根据跟踪者查询
     * @param tracker
     * @return
     */
    public List<ProjectTrack> findProjectTrackByTracker(int tracker);
}
