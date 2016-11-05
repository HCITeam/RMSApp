package controller;

import entity.UserEntity;
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
@RequestMapping("/systemManager")
public class SystemManagerController extends  BaseController{
    
    @Autowired
    private UserService userService;
    
 
    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    @ResponseBody
    public String addUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params=getParams(request);
        String name=params.get("name");
        String password=params.get("pwd");
        UserEntity userEntity=new UserEntity();
        userEntity.setName(name);
        userEntity.setPassword(password);
        userService.addUser(userEntity);
        return "success" ;
    }
    
    @ResponseBody
    @RequestMapping("/findUser")
    public UserEntity findUser(HttpServletRequest request, HttpServletResponse response){
        UserEntity user=userService.findUser("zch");
        return  user;
    }
}
