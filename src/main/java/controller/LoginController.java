package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Tamsen on 16/11/6.
 */
@Controller
@RequestMapping("/")
public class LoginController extends  BaseController{
    
    @Autowired
    private UserService userService;
    
    @ResponseBody
    @RequestMapping("/login")//if login failed,return null;else return the user
    public User login(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        String name=params.get("name");
        String password=params.get("password");
        User user=userService.login(name,password);
        return  user;
    }
}
