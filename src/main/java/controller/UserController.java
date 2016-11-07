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
    
 
    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    @ResponseBody
    public User addUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         name=params.get("name");
         password=params.get("password");
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        userService.addUser(user);
        user=userService.findUserByName(name);
        return user ;
    }
    @ResponseBody
    @RequestMapping("/deleteUser")
    public User deleteUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
        User user=userService.findUserByID(id);
        userService.deleteUser(user);
        return  user;
    }
    @ResponseBody
    @RequestMapping("/updateUser")
    public User updateUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         id=Integer.parseInt(params.get("id"));
         name=params.get("name");
         password=params.get("password");
        User user=userService.findUserByID(id);
        user.setName(name);
        user.setPassword(password);
        userService.updateUser(user);
        return  user;
    }
    @ResponseBody
    @RequestMapping("/findUserByName")
    public User findUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
         name=params.get("name");
        User user=userService.findUserByName(name);
        return  user;
    }
     int id;
    String name;
    String password;
}
