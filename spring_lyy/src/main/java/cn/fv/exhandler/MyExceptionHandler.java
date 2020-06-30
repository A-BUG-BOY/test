package cn.fv.exhandler;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class MyExceptionHandler implements HandlerExceptionResolver {

    //自定义异常处理
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        HashMap<String,Object> model = new HashMap<>();
        model.put("exception",e);
        //根据不同的异常类型返回不同的页面
        if (e instanceof Exception){

            return new ModelAndView("404",model);
        }
        return null;
    }
}
