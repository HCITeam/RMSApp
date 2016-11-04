package controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import util.ParamContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chenm on 2016/5/12.
 */
@Controller
public class DemoChildController extends BaseController {
    @Override
    @RequestMapping("child")
    // 进行路由控制（一般一个url对应一个controller，所以直接跳转到默认controller即可)
    // 该Demo是模拟一个表单提交的action，打开 "localhost:????/child?username=xxxxx" 可以看到效果
    public String route(HttpServletResponse response, HttpServletRequest request, Model model) {
        return (String)controller(response,request,model);
    }

    @Override
    // 进行参数验证
    // params放置了参数列表
    // 返回的Object是需要跳转的url，或者对应的jsp页面，或者json字符串和对象
    public Object validate(ParamContainer params) {
        String name = params.getS("username");
        if(name.length() < 6) {
            return "redirect: show?username=The length of username should be greater than 5"; // 直接跳转到某个页面（如404），ajax的话直接返回一个带有错误信息的json字符串或者对象
        } else {
            return null;//验证无错误，返回null，跳到process做核心逻辑处理
        }
    }

    @Override
    // 核心处理逻辑
    // 同validate，params放置了参数列表
    // 返回的Object是需要跳转的url，或者对应的jsp页面，或者json字符串和对象
    public Object process(ParamContainer params) {
        String name = params.getS("username");

        return "redirect: show?username="+name;
    }
}
