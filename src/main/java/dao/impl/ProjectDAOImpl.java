package dao.impl;

import dao.ProjectDAO;
import entity.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
@Repository
public class ProjectDAOImpl extends BaseDAOImpl<Project> implements ProjectDAO {
    @Override
    public Project findProjectByID(int id) {
        return getByColumn("id",id);
    }
    
    @Override
    public List<Project> findProjectByCreater(int creater) {
        return getListByColumn("creater",creater);
    }
}
