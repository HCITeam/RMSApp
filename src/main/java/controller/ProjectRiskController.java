package controller;

import entity.ProjectRisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ProjectRiskService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tamsen on 16/11/6.
 */
@Controller
@RequestMapping("/projectRisk")
public class ProjectRiskController extends BaseController{
    @Autowired
    private ProjectRiskService projectRiskService;
    
    @RequestMapping(value="/addProjectRisk",method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,String>> addProjectRisk(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         project_id=Integer.parseInt(params.get("projectId"));
         content=params.get("content");
         possibility=Integer.parseInt(params.get("possibility"));
         influenceLevel=Integer.parseInt(params.get("influenceLevel"));
         threshold=Integer.parseInt(params.get("threshold"));
         creater=Integer.parseInt(params.get("creater"));
         tracker=Integer.parseInt(params.get("tracker"));
        ProjectRisk projectRisk=new ProjectRisk();
        projectRisk.setProjectId(project_id);
        projectRisk.setContent(content);
        projectRisk.setPossibility(possibility);
        projectRisk.setInfluenceLevel(influenceLevel);
        projectRisk.setThreshold(threshold);
        projectRisk.setCreater(creater);
        projectRisk.setTracker(tracker);
        projectRiskService.addProjectRisk(projectRisk);
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Map<String,String>>mapList=new ArrayList<Map<String,String>>();
        Map<String,String>map=new HashMap<String,String>();
        map.put("message","success");
        mapList.add(map);
        return mapList;
    }
    @ResponseBody
    @RequestMapping("/deleteProjectRisk")
    public ProjectRisk deleteProjectRisk(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
        ProjectRisk projectRisk=projectRiskService.findProjectRiskByID(id);
        projectRiskService.deleteProjectRisk(projectRisk);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return  projectRisk;
    }
    @ResponseBody
    @RequestMapping("/updateProjectRisk")
    public ProjectRisk updateProjectRisk(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
         project_id=Integer.parseInt(params.get("projectId"));
         content=params.get("content");
         possibility=Integer.parseInt(params.get("possibility"));
         influenceLevel=Integer.parseInt(params.get("influenceLevel"));
         threshold=Integer.parseInt(params.get("threshold"));
         creater=Integer.parseInt(params.get("creater"));
         tracker=Integer.parseInt(params.get("tracker"));
        ProjectRisk projectRisk=projectRiskService.findProjectRiskByID(id);
        projectRisk.setProjectId(project_id);
        projectRisk.setContent(content);
        projectRisk.setPossibility(possibility);
        projectRisk.setInfluenceLevel(influenceLevel);
        projectRisk.setThreshold(threshold);
        projectRisk.setCreater(creater);
        projectRisk.setTracker(tracker);
        projectRiskService.updateProjectRisk(projectRisk);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return  projectRisk;
    }
    @ResponseBody
    @RequestMapping("/findProjectRiskByProject")
    public List<ProjectRisk> findProjectRiskByProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         project_id=Integer.parseInt(params.get("projectId"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectRiskService.findProjectRiskByProject(project_id);
       
    }
    
    @ResponseBody
    @RequestMapping("/findProjectRiskByID")
    public ProjectRisk findProjectRiskByID(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectRiskService.findProjectRiskByID(id);
      
    }
    int id;
    int project_id;
    String content;
    int possibility;
    int influenceLevel;
    int threshold;
    int creater;
    int tracker;
}
