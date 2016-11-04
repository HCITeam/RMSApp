package controller.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DemoService;
import vo.DemoVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenm on 2016/5/6.
 */
@Controller
@RequestMapping("/")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/save")
    public String index(Model model){
        List<DemoVO> us = new ArrayList<DemoVO>();
        DemoVO u = new DemoVO();
        u.username = "MarK";
        us.add(u);
        u = new DemoVO();
        u.username = "MarK";
        us.add(u);
        model.addAttribute("username",u.username);
        demoService.saveUsers(us);
        return "index";
    }


    // 进行路由，映射到某一个url
    // 前端页面需要的参数置于model中，传过来的参数置于request中
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

    @RequestMapping("/form")
    public String dealForm(HttpServletResponse response, HttpServletRequest request){
        List<DemoVO> us = new ArrayList<DemoVO>();
        DemoVO u = new DemoVO();
        u.username = request.getParameter("username");
        us.add(u);
        demoService.saveUsers(us);
        System.out.println("1:"+request.getParameter("form-test-1")
                +" 2:"+request.getParameter("form-test-2")
                +" 3:"+request.getParameter("sub-test-1")
                +" 4:"+request.getParameter("sub-test-2")
                +" 5:"+request.getParameter("username")
                +" 6:"+request.getParameter("username2")
        );
        System.out.println("2:"+request.getMethod());
        return "redirect:/show?username="+ u.username;
    }

    @RequestMapping("/json")
    //返回的是json时，加入@ResponseBody注解，springMVC才不会将返回值作为url处理
    @ResponseBody
    public DemoVO dealAjax(HttpServletResponse response, HttpServletRequest request) {
        DemoVO demoVO = new DemoVO();
        demoVO.username = request.getParameter("name");

        return demoVO; // 可以直接返回对象，会被转成json数组
    }
}
