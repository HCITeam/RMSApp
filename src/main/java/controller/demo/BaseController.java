package controller.demo;

import org.springframework.ui.Model;
import util.ParamContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chenm on 2016/5/8.
 */
public abstract class BaseController {
    Model model;

    /**
     * 路由控制
     *
     * @param response
     * @param request
     * @return
     */
    public abstract String route(HttpServletResponse response, HttpServletRequest request, Model model);

    /**
     * 主控制器
     *
     * @param response
     * @param request
     * @return
     */
    @SuppressWarnings({"unchecked"})
    public Object controller(HttpServletResponse response, HttpServletRequest request, Model model) {
        this.model = model;
        ParamContainer params = new ParamContainer(getParams(request.getParameterMap()));

        if(validate(params) != null) {
            return validate(params);
        }

        return process(params);
    }

    /**
     * 参数验证
     *
     * @param params
     * @return 为空则为正确，否则返回对应的链接或者json
     */
    public abstract Object validate(ParamContainer params);

    /**
     * 主要逻辑
     *
     * @param params
     */
    public abstract Object process(ParamContainer params);

    public Map<String, Object> getParams(Map<String, String[]> in) {

        Map<String, Object> out = new HashMap<String, Object>();
        Iterator<Map.Entry<String, String[]>> i = in.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<String, String[]> entry = i.next();
            out.put(entry.getKey(), entry.getValue()[0]);
        }
        return out;
    }
}
