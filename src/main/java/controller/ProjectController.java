package controller;

import entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
/**
 * Created by Tamsen on 16/11/6.
 */
@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController{
    
    @Autowired
    private ProjectService projectService;
    
    @RequestMapping(value="/addProject",method = RequestMethod.POST)
    @ResponseBody
    public String addProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        String name=params.get("name");
        String describe=params.get("describe");
        int creater=Integer.parseInt(params.get("creater"));
        Project project=new Project();
        project.setName(name);
        project.setDescribe(describe);
        project.setCreater(creater);
        projectService.addProject(project);
        return "success" ;
    }
    @ResponseBody
    @RequestMapping("/deleteProject")
    public Project deleteProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        Project project=projectService.findProjectByID(id);
        projectService.deleteProject(project);
        return  project;
    }
    @ResponseBody
    @RequestMapping("/updateProject")
    public Project updateProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        String name=params.get("name");
        String describe=params.get("describe");
        Project project=projectService.findProjectByID(id);
        project.setName(name);
        project.setDescribe(describe);
        projectService.updateProject(project);
        return  project;
    }
    @ResponseBody
    @RequestMapping("/findProjectByCreater")
    public List<Project> findProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        String creater=params.get("creater");
        List<Project> projectList=projectService.findProjectByCreater(creater);
        return  projectList;
    }
}
