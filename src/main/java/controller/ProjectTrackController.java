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

    /**
     * 新增跟踪
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/addProjectTrack",method = RequestMethod.POST)
    @ResponseBody
    public ProjectTrack addProjectTrack(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        riskId=Integer.parseInt(params.get("riskId"));
         risk=params.get("risk");
         state=Integer.parseInt(params.get("state"));
         cause=params.get("cause");
         tracker=Integer.parseInt(params.get("tracker"));
         update_time=params.get("updateTime");
        ProjectTrack projectTrack=new ProjectTrack();
        projectTrack.setRiskId(riskId);
        projectTrack.setRisk(risk);
        projectTrack.setState(state);
        projectTrack.setCause(cause);
        projectTrack.setTracker(tracker);
       
        projectTrack.setUpdateTime(Timestamp.valueOf(update_time));
        projectTrack=projectTrackService.addProjectTrack(projectTrack);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectTrack;
    }

    /**
     * 删除跟踪
     * @param request
     * @param response
     * @return
     */
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

    /**
     * 更新跟踪
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateProjectTrack")
    public ProjectTrack updateProjectTrack(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
        riskId=Integer.parseInt(params.get("riskId"));
         risk=params.get("risk");
         state=Integer.parseInt(params.get("state"));
         cause=params.get("cause");
         tracker=Integer.parseInt(params.get("tracker"));
        String update_time=params.get("updateTime");
        ProjectTrack projectTrack=projectTrackService.findProjectTrackByID(id);
        projectTrack.setRiskId(riskId);
        projectTrack.setRisk(risk);
        projectTrack.setState(state);
        projectTrack.setCause(cause);
        projectTrack.setTracker(tracker);
      
        
        projectTrack.setUpdateTime(Timestamp.valueOf(update_time));
        
        projectTrackService.updateProjectTrack(projectTrack);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectTrack;
    }

    /**
     * 查询某个项目的跟踪信息
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findProjectTrackByRisk")
    public List<ProjectTrack> findProjectByCreater(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        riskId=Integer.parseInt(params.get("riskId"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectTrackService.findProjectTrackByRisk(riskId);
       
    }

    /**
     * 通过跟踪者查询跟踪
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findProjectTrackByTracker")
    public List<ProjectTrack> findProjectTrackByTracker(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         tracker=Integer.parseInt(params.get("tracker"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectTrackService.findProjectTrackByTracker(tracker);
       
    }

    /**
     * 通过ID查询
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findProjectTrackByID")
    public ProjectTrack findProjectTrackByID(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectTrackService.findProjectTrackByID(id);
       
    }
    int id;
    int riskId;
    String risk;
    int state;
    String cause;
    int tracker;
    String update_time;
}
