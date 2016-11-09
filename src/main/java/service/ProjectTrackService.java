package service;

import entity.ProjectTrack;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectTrackService {
    public ProjectTrack addProjectTrack(ProjectTrack projectTrack);
    public boolean deleteProjectTrack(ProjectTrack projectTrack);
    public boolean updateProjectTrack(ProjectTrack projectTrack);
    public  ProjectTrack findProjectTrackByID(int id);
    public List<ProjectTrack> findProjectTrackByProject(int projectID);
    public List<ProjectTrack> findProjectTrackByTracker(int tracker);
}
