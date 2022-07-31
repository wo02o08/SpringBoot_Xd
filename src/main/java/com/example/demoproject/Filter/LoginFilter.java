package com.example.demoproject.Filter;

import com.example.demoproject.domain.User;
import com.example.demoproject.server.impl.UserServiceImpl;
import com.example.demoproject.utils.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@WebFilter(urlPatterns = "/order/save", filterName = "LoginFilter")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("LoginFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("LoginFilter doFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
        if (token == null ) {
            token = request.getParameter("token");
        }

        //判断token是否存在
        if (token == null) {
            response.setStatus(-3);
            response.getWriter().write("{\"code\":-3,\"msg\":\"token is null, 未登录\"}");
        } else {
            User user = UserServiceImpl.session.get(token);
            if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.setStatus(-2);
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write("{\"code\":-2,\"msg\":\",token失效，请登录\"}");
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter destroy");
    }

    // 判断是否登录


    @Autowired
    private ObjectMapper objectMapper;

    private void renderJson(HttpServletResponse response, String json) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            json = objectMapper.writeValueAsString(JsonData.buildError(-2, "请登录"));
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getJson(String key, String value) {
        return String.format("{\"%s\":\"%s\"}", key, value);
    }



}
