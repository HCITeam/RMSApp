package controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by raychen on 16/5/14.
 */
public abstract class BaseController {
    /**
     * 用于处理前端请求时的参数
     * @param request 网络请求
     * @return 整理出来的参数
     */
    public Map<String, String> getParams(HttpServletRequest request) {
        Map<String, String[]> in = request.getParameterMap();
        Map<String, String> out = new HashMap<>();
        Iterator<Map.Entry<String, String[]>> i = in.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<String, String[]> entry = i.next();
            out.put(entry.getKey(), entry.getValue()[0]);
        }
        return out;
    }
    
}
