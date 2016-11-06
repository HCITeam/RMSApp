package controller;

import entity.ProjectUserRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ProjectUserRelationshipService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Tamsen on 16/11/6.
 */
@Controller
@RequestMapping("/projectUserRelationship")
public class ProjectUserRelationshipController extends  BaseController{
    @Autowired
    private ProjectUserRelationshipService projectUserRelationshipService;
   
    @RequestMapping(value="/addProjectUserRelationship",method = RequestMethod.POST)
    @ResponseBody
    public String addProjectUserRelationship(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int user=Integer.parseInt(params.get("user_id"));
        int project=Integer.parseInt(params.get("project_id"));
        ProjectUserRelationship projectUserRelationship=new ProjectUserRelationship();
        projectUserRelationship.setUserId(user);
        projectUserRelationship.setProjectId(project);
        projectUserRelationshipService.addProjectUserRelationship(projectUserRelationship);
        return "success" ;
    }
    @ResponseBody
    @RequestMapping("/deleteProjectUserRelationship")
    public ProjectUserRelationship deleteProjectUserRelationship(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        ProjectUserRelationship projectUserRelationship=projectUserRelationshipService.findProjectUserRelationshipByID(id);
        projectUserRelationshipService.deleteProjectUserRelationship(projectUserRelationship);
        return  projectUserRelationship;
    }
    
    @ResponseBody
    @RequestMapping("/findProjectUserRelationshipByUser")
    public List<ProjectUserRelationship> findProjectUserRelationshipByUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int user=Integer.parseInt(params.get("user_id"));
        List<ProjectUserRelationship> list=projectUserRelationshipService.findProjectUserRelationshipByUser(user);
        return  list;
    }
    
    @ResponseBody
    @RequestMapping("/findProjectUserRelationshipByProject")
    public List<ProjectUserRelationship> findProjectUserRelationshipByProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int project=Integer.parseInt(params.get("project_id"));
        List<ProjectUserRelationship> list=projectUserRelationshipService.findProjectUserRelationshipByProject(project);
        return  list;
    }
}
