package service.impl;

import dao.ProjectTrackDAO;
import entity.ProjectTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ProjectTrackService;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
@Service
@Transactional
public class ProjectTrackServiceImpl  implements ProjectTrackService{
    
    @Autowired
    private ProjectTrackDAO projectTrackDAO;
    
    @Override
    public ProjectTrack addProjectTrack(ProjectTrack projectTrack) {
        projectTrackDAO.add(projectTrack);
        return (ProjectTrack)projectTrackDAO.getNewAddedEntity();
    }
    
    @Override
    public boolean deleteProjectTrack(ProjectTrack projectTrack) {
        projectTrackDAO.delete(projectTrack);
        return true;
    }
    
    @Override
    public boolean updateProjectTrack(ProjectTrack projectTrack) {
        projectTrackDAO.update(projectTrack);
        return true;
    }
    
    @Override
    public ProjectTrack findProjectTrackByID(int id) {
        return projectTrackDAO.findProjectTrackerByID(id);
    }
    
    @Override
    public List<ProjectTrack> findProjectTrackByProject(int projectID) {
        return projectTrackDAO.findProjectTrackByProject(projectID);
    }
    
    @Override
    public List<ProjectTrack> findProjectTrackByTracker(int tracker) {
        return projectTrackDAO.findProjectTrackByTracker(tracker);
    }
}
