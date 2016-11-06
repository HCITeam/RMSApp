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
    public String addProjectRisk(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int project_id=Integer.parseInt(params.get("project_id"));
        String content=params.get("content");
        int possibility=Integer.parseInt(params.get("possibility"));
        int influenceLevel=Integer.parseInt(params.get("influenceLevel"));
        int threshold=Integer.parseInt(params.get("threshold"));
        int creater=Integer.parseInt(params.get("creater"));
        int tracker=Integer.parseInt(params.get("tracker"));
        ProjectRisk projectRisk=new ProjectRisk();
        projectRisk.setProjectId(project_id);
        projectRisk.setContent(content);
        projectRisk.setPossibility(possibility);
        projectRisk.setInfluenceLevel(influenceLevel);
        projectRisk.setThreshold(threshold);
        projectRisk.setCreater(creater);
        projectRisk.setTracker(tracker);
        projectRiskService.addProjectRisk(projectRisk);
        return "success" ;
    }
    @ResponseBody
    @RequestMapping("/deleteProjectRisk")
    public ProjectRisk deleteProjectRisk(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        ProjectRisk projectRisk=projectRiskService.findProjectRiskByID(id);
        projectRiskService.deleteProjectRisk(projectRisk);
        return  projectRisk;
    }
    @ResponseBody
    @RequestMapping("/updateProjectRisk")
    public ProjectRisk updateProjectRisk(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        int project_id=Integer.parseInt(params.get("project_id"));
        String content=params.get("content");
        int possibility=Integer.parseInt(params.get("possibility"));
        int influenceLevel=Integer.parseInt(params.get("influenceLevel"));
        int threshold=Integer.parseInt(params.get("threshold"));
        int creater=Integer.parseInt(params.get("creater"));
        int tracker=Integer.parseInt(params.get("tracker"));
        ProjectRisk projectRisk=projectRiskService.findProjectRiskByID(id);
        projectRisk.setProjectId(project_id);
        projectRisk.setContent(content);
        projectRisk.setPossibility(possibility);
        projectRisk.setInfluenceLevel(influenceLevel);
        projectRisk.setThreshold(threshold);
        projectRisk.setCreater(creater);
        projectRisk.setTracker(tracker);
        projectRiskService.updateProjectRisk(projectRisk);
        return  projectRisk;
    }
    @ResponseBody
    @RequestMapping("/findProjectRiskByProject")
    public List<ProjectRisk> findProjectRiskByProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int project=Integer.parseInt(params.get("project_id"));
        List<ProjectRisk> projectRiskList=projectRiskService.findProjectRiskByProject(project);
        return  projectRiskList;
    }
    
    @ResponseBody
    @RequestMapping("/findProjectRiskByID")
    public ProjectRisk findProjectRiskByID(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        ProjectRisk projectRisk=projectRiskService.findProjectRiskByID(id);
        return  projectRisk;
    }
}
