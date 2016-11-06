package service;

import entity.Project;

import java.util.List;

/**
 * Created by Tamsen on 16/11/6.
 */
public interface ProjectService {
    public boolean addProject(Project project);
    public boolean deleteProject(Project project);
    public boolean updateProject(Project project);
    public Project findProjectByID(int id);
    public List<Project> findProjectByCreater(String creater);
}
