package dao.impl;

import dao.ProjectRiskDAO;
import entity.ProjectRisk;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
@Repository
public class ProjectRiskDAOImpl extends BaseDAOImpl<ProjectRisk> implements ProjectRiskDAO{
   
    @Override
    public List<ProjectRisk> findProjectRiskByProject(int projectID){
        return  getListByColumn("projectId",projectID);
    }
    
    @Override
    public ProjectRisk findProjectRiskByID(int id) {
        return getByColumn("id",id);
    }
}
