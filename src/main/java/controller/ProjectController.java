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
         name=params.get("name");
         description=params.get("description");
         creater=Integer.parseInt(params.get("creater"));
        Project project=new Project();
        project.setName(name);
        project.setDescription(description);
        project.setCreater(creater);
        projectService.addProject(project);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "success" ;
    }
    @ResponseBody
    @RequestMapping("/deleteProject")
    public Project deleteProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
        Project project=projectService.findProjectByID(id);
        projectService.deleteProject(project);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return  project;
    }
    @ResponseBody
    @RequestMapping("/updateProject")
    public Project updateProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
         name=params.get("name");
         description=params.get("description");
        Project project=projectService.findProjectByID(id);
        project.setName(name);
        project.setDescription(description);
        projectService.updateProject(project);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return  project;
    }
    @ResponseBody
    @RequestMapping("/findProjectByCreater")
    public List<Project> findProjectByCreater(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         creater=Integer.parseInt(params.get("creater"));
        return projectService.findProjectByCreater(creater);
       
    }
    
    @ResponseBody
    @RequestMapping("/findProjectByID")
    public Project findProjectByID(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectService.findProjectByID(id);
        
    }
    int id;
    String name;
    String description;
    int creater;
}
