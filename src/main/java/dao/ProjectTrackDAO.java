package dao;

import entity.ProjectTrack;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectTrackDAO extends  BaseDAO<ProjectTrack> {
    /**
     * 项目id查询
     * @param riskId
     * @return
     */
    public List<ProjectTrack> findProjectTrackByRisk(int riskId);

    /**
     * 跟踪者id查询
     * @param tracker
     * @return
     */
    public List<ProjectTrack> findProjectTrackByTracker(int tracker);

    /**
     * 跟踪项id查询
     * @param id
     * @return
     */
    public ProjectTrack findProjectTrackerByID(int id);
}
