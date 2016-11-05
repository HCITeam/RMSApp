package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import service.UserServiceImpl;
import entity.UserEntity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by mj on 16/11/5.
 */
@Controller
@RequestMapping("/")
public class SystemManagerController {
   
    private UserService userService;
    
    public SystemManagerController(){
        this.userService=new UserServiceImpl();
    }
    
    
    @RequestMapping("/show")
    public String show(HttpServletResponse response, HttpServletRequest request, Model model) {
        
        if(request.getParameter("username")!=null){
            model.addAttribute("helloPara", request.getParameter("username"));// 获取jsp传回的参数
        }else {
            model.addAttribute("helloPara", "Hello world!"); // 往jsp传参
            model.addAttribute("i", 1); // 往jsp传参
            model.addAttribute("bool", true); // 往jsp传参
            
            ArrayList<String> strs = new ArrayList<String>();
            strs.add("hhhhh");
            strs.add("eeeee");
            strs.add("iiiii");
            
            model.addAttribute("list", strs);
        }
        return "demo"; // 定位到/jsp/demo.jsp
    }
//    @RequestMapping("/addUser")
//    @ResponseBody
//    public String addUser(HttpServletRequest request, HttpServletResponse response){
//        System.out.println("hhhhhhhhhhhhh");
//        userService.addUser();
//        System.out.println("ahhhahahah");
//        return "redirect:/show?username="+ "lmj" ;
//    }
    
    @ResponseBody
    @RequestMapping("/findUser")
    public UserEntity findUser(HttpServletRequest request, HttpServletResponse response){
        UserEntity user=userService.findUser("zch");
        return  user;
    }
}
