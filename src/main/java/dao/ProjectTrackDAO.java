package dao;

import entity.ProjectTrack;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectTrackDAO extends  BaseDAO<ProjectTrack> {
    public List<ProjectTrack> findProjectTrackByProject(int projectID);
    public List<ProjectTrack> findProjectTrackByTracker(int tracker);
    public ProjectTrack findProjectTrackerByID(int id);
}
