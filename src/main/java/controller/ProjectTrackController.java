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
import java.text.SimpleDateFormat;
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
    public String addProjectTrack(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int project_id=Integer.parseInt(params.get("project_id"));
        String risk=params.get("risk");
        int state=Integer.parseInt(params.get("state"));
        String cause=params.get("cause");
        int tracker=Integer.parseInt(params.get("tracker"));
        String update_time=params.get("update_time");
        ProjectTrack projectTrack=new ProjectTrack();
        projectTrack.setProjectId(project_id);
        projectTrack.setRisk(risk);
        projectTrack.setState(state);
        projectTrack.setCause(cause);
        projectTrack.setTracker(tracker);
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        projectTrack.setUpdateTime(Timestamp.valueOf(update_time));
        projectTrackService.addProjectTrack(projectTrack);
        return "success" ;
    }
    @ResponseBody
    @RequestMapping("/deleteProjectTrack")
    public ProjectTrack deleteProjectTrack(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        ProjectTrack projectTrack=projectTrackService.findProjectTrackByID(id);
        projectTrackService.deleteProjectTrack(projectTrack);
        return  projectTrack;
    }
    @ResponseBody
    @RequestMapping("/updateProjectTrack")
    public ProjectTrack updateProjectTrack(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        int project_id=Integer.parseInt(params.get("project_id"));
        String risk=params.get("risk");
        int state=Integer.parseInt(params.get("state"));
        String cause=params.get("cause");
        int tracker=Integer.parseInt(params.get("tracker"));
        String update_time=params.get("update_time");
        ProjectTrack projectTrack=projectTrackService.findProjectTrackByID(id);
        projectTrack.setProjectId(project_id);
        projectTrack.setRisk(risk);
        projectTrack.setState(state);
        projectTrack.setCause(cause);
        projectTrack.setTracker(tracker);
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        projectTrack.setUpdateTime(Timestamp.valueOf(update_time));
        
        projectTrackService.updateProjectTrack(projectTrack);
        return projectTrack;
    }
    @ResponseBody
    @RequestMapping("/findProjectTrackByProject")
    public List<ProjectTrack> findProjectByCreater(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int project=Integer.parseInt(params.get("project_id"));
        List<ProjectTrack> projectTrackList=projectTrackService.findProjectTrackByProject(project);
        return  projectTrackList;
    }
    @ResponseBody
    @RequestMapping("/findProjectTrackByTracker")
    public List<ProjectTrack> findProjectTrackByTracker(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int tracker=Integer.parseInt(params.get("tracker"));
        List<ProjectTrack> projectTrackList=projectTrackService.findProjectTrackByTracker(tracker);
        return  projectTrackList;
    }
    
    @ResponseBody
    @RequestMapping("/findProjectTrackByID")
    public ProjectTrack findProjectTrackByID(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        ProjectTrack projectTrack=projectTrackService.findProjectTrackByID(id);
        return  projectTrack;
    }
}
