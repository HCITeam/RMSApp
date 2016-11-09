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
    public ProjectUserRelationship  addProjectUserRelationship(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         userId=Integer.parseInt(params.get("userId"));
         projectId=Integer.parseInt(params.get("projectId"));
        ProjectUserRelationship projectUserRelationship=new ProjectUserRelationship();
        projectUserRelationship.setUserId(userId);
        projectUserRelationship.setProjectId(projectId);
        projectUserRelationship=projectUserRelationshipService.addProjectUserRelationship(projectUserRelationship);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectUserRelationship;
    }
    @ResponseBody
    @RequestMapping("/deleteProjectUserRelationship")
    public ProjectUserRelationship deleteProjectUserRelationship(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
        ProjectUserRelationship projectUserRelationship=projectUserRelationshipService.findProjectUserRelationshipByID(id);
        projectUserRelationshipService.deleteProjectUserRelationship(projectUserRelationship);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return  projectUserRelationship;
    }
    
    @ResponseBody
    @RequestMapping("/findProjectUserRelationshipByUser")
    public List<ProjectUserRelationship> findProjectUserRelationshipByUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         userId=Integer.parseInt(params.get("userId"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectUserRelationshipService.findProjectUserRelationshipByUser(userId);
        
    }
    
    @ResponseBody
    @RequestMapping("/findProjectUserRelationshipByProject")
    public List<ProjectUserRelationship> findProjectUserRelationshipByProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         projectId=Integer.parseInt(params.get("projectId"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectUserRelationshipService.findProjectUserRelationshipByProject(projectId);
        
    }
    int id;
    int userId;
    int projectId;
}
