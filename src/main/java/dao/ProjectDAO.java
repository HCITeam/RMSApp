package dao;

import entity.Project;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectDAO extends BaseDAO<Project>{
    /**
     * id查询数据库
     * @param id
     * @return
     */
    public Project findProjectByID(int id);

    /**
     * 根据创建者id查询
     * @param creater
     * @return
     */
    public List<Project> findProjectByCreater(int creater);
}
