package dao.impl;

import dao.ProjectTrackDAO;
import entity.ProjectTrack;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
@Repository
public class ProjectTrackDAOImpl extends  BaseDAOImpl<ProjectTrack>  implements ProjectTrackDAO{
    @Override
    public List<ProjectTrack> findProjectTrackByRisk(int riskId) {
        return getListByColumn("riskId",riskId);
    }
    
    @Override
    public List<ProjectTrack> findProjectTrackByTracker(int tracker) {
        return getListByColumn("tracker",tracker);
    }
    
    @Override
    public ProjectTrack findProjectTrackerByID(int id) {
        return getByColumn("id",id);
    }
}
