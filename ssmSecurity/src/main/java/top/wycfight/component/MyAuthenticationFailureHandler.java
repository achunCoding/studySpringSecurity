package top.wycfight.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 自定义登录失败返回结果
 * @create: 2019-08-04 19:23
 * @modify By:
 **/
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Map<String,Object> result = new HashMap<>(16);
        result.put("success",false);
        String json = objectMapper.writeValueAsString(result);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(json);
    }
}
