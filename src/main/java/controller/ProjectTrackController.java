package controller;

import entity.ProjectTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ProjectTrackService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Tamsen on 16/11/6.
 */
@Controller
@RequestMapping("/projectTrack")
public class ProjectTrackController extends  BaseController {
    
    @Autowired
    private ProjectTrackService projectTrackService;
    
    @RequestMapping(value="/addProjectTrack",method = RequestMethod.POST)
    @ResponseBody
    public ProjectTrack addProjectTrack(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         project_id=Integer.parseInt(params.get("projectId"));
         risk=params.get("risk");
         state=Integer.parseInt(params.get("state"));
         cause=params.get("cause");
         tracker=Integer.parseInt(params.get("tracker"));
         update_time=params.get("updateTime");
        ProjectTrack projectTrack=new ProjectTrack();
        projectTrack.setProjectId(project_id);
        projectTrack.setRisk(risk);
        projectTrack.setState(state);
        projectTrack.setCause(cause);
        projectTrack.setTracker(tracker);
       
        projectTrack.setUpdateTime(Timestamp.valueOf(update_time));
        projectTrack=projectTrackService.addProjectTrack(projectTrack);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectTrack;
    }
    @ResponseBody
    @RequestMapping("/deleteProjectTrack")
    public ProjectTrack deleteProjectTrack(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        ProjectTrack projectTrack=projectTrackService.findProjectTrackByID(id);
        projectTrackService.deleteProjectTrack(projectTrack);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return  projectTrack;
    }
    @ResponseBody
    @RequestMapping("/updateProjectTrack")
    public ProjectTrack updateProjectTrack(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
         project_id=Integer.parseInt(params.get("projectId"));
         risk=params.get("risk");
         state=Integer.parseInt(params.get("state"));
         cause=params.get("cause");
         tracker=Integer.parseInt(params.get("tracker"));
        String update_time=params.get("updateTime");
        ProjectTrack projectTrack=projectTrackService.findProjectTrackByID(id);
        projectTrack.setProjectId(project_id);
        projectTrack.setRisk(risk);
        projectTrack.setState(state);
        projectTrack.setCause(cause);
        projectTrack.setTracker(tracker);
      
        
        projectTrack.setUpdateTime(Timestamp.valueOf(update_time));
        
        projectTrackService.updateProjectTrack(projectTrack);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectTrack;
    }
    @ResponseBody
    @RequestMapping("/findProjectTrackByProject")
    public List<ProjectTrack> findProjectByCreater(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         project_id=Integer.parseInt(params.get("projectId"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectTrackService.findProjectTrackByProject(project_id);
       
    }
    @ResponseBody
    @RequestMapping("/findProjectTrackByTracker")
    public List<ProjectTrack> findProjectTrackByTracker(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         tracker=Integer.parseInt(params.get("tracker"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectTrackService.findProjectTrackByTracker(tracker);
       
    }
    
    @ResponseBody
    @RequestMapping("/findProjectTrackByID")
    public ProjectTrack findProjectTrackByID(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectTrackService.findProjectTrackByID(id);
       
    }
    int id;
    int project_id;
    String risk;
    int state;
    String cause;
    int tracker;
    String update_time;
}
