package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
/**
 * Created by mj on 16/11/5.
 */
@Controller
@RequestMapping("/user")
public class UserController extends  BaseController{
    
    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    @ResponseBody
    public User addUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        String name=params.get("name");
        String password=params.get("password");
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setStatus(1);
        user=userService.addUser(user);
        return user ;
    }

    /**
     * 删除用户
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteUser")
    public User deleteUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        User user=userService.findUserByID(id);
        userService.deleteUser(user);
        return  user;
    }

    /**
     * 更新用户信息
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateUser")
    public User updateUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        String name=params.get("name");
        String password=params.get("password");
        User user=userService.findUserByID(id);
        user.setName(name);
        user.setPassword(password);
        userService.updateUser(user);
        return  user;
    }

    /**
     * 通过用户名查询用户
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findUserByName")
    public User findUserByName(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        String name=params.get("name");
        User user=userService.findUserByName(name);
        return  user;
    }

    /**
     * 通过ID查询用户
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findUserByID")
    public User findUserByID(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        int id=Integer.parseInt(params.get("id"));
        User user=userService.findUserByID(id);
        return  user;
    }
}
