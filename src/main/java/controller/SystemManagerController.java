package controller;

import entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by mj on 16/11/5.
 */
@Controller
@RequestMapping("/systemManager")
public class SystemManagerController {
   
    private UserService userService;
    
    public SystemManagerController(){
        this.userService=new UserServiceImpl();
    }
    
    @RequestMapping(value="/addUser")
    public UserEntity addUser(HttpServletRequest request, HttpServletResponse response){
        userService.addUser();
        return  new UserEntity();
    }
}
