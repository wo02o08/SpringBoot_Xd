package com.example.demoproject.Handler;

import com.example.demoproject.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;


/**
 * 异常处理类
 *
 */
//返回Json数据
//@RestControllerAdvice
@ControllerAdvice
public class CustomExtHandler {

   //那类异常抛出的异常处理器
//    @ExceptionHandler(value = Exception.class)
//        //请求信息
//    Object handleException(Exception e, HttpServletResponse response) {
//        return JsonData.buildError(-2,e.getMessage());
//    }
    @ExceptionHandler(value = Exception.class)
        //请求信息
    Object handleException(Exception e, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error.html");
        mv.addObject("msg",e.getMessage());
        return mv;
    }


}
