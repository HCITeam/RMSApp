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

    /**
     * 新增项目，操作者成为该项目的项目经理
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/addProject",method = RequestMethod.POST)
    @ResponseBody
    public Project addProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        String name=params.get("name");
        String description=params.get("description");
        int creater=Integer.parseInt(params.get("creater"));
        Project project=new Project();
        project.setName(name);
        project.setDescription(description);
        project.setCreater(creater);
        project=projectService.addProject(project);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return project;
    }

    /**
     * 删除项目
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteProject")
    public Project deleteProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        Project project=projectService.findProjectByID(id);
        projectService.deleteProject(project);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return  project;
    }

    /**
     * 更新项目信息
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateProject")
    public Project updateProject(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        String name=params.get("name");
        String description=params.get("description");
        Project project=projectService.findProjectByID(id);
        project.setName(name);
        project.setDescription(description);
        projectService.updateProject(project);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return  project;
    }

    /**
     * 通过用户查询其创建的项目
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findProjectByCreater")
    public List<Project> findProjectByCreater(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int creater=Integer.parseInt(params.get("creater"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectService.findProjectByCreater(creater);
       
    }


    /**
     * 通过ID查询用户
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findProjectByID")
    public Project findProjectByID(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return projectService.findProjectByID(id);
        
    }
}
