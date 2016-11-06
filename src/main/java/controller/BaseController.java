package controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by raychen on 16/5/14.
 */
public abstract class BaseController {
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
