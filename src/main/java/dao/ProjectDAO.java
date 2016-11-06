package dao;

import entity.Project;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectDAO extends BaseDAO<Project>{
    public Project findProjectByID(int id);
    public List<Project> findProjectByCreater(int creater);
}
