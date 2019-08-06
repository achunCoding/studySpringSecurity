package top.wycfight.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 自定义登录成功相应结果
 * @create: 2019-08-04 19:19
 * @modify By:
 **/
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map<String,Object> result = new HashMap<>(16);
        result.put("success","true");
        String json = objectMapper.writeValueAsString(result);
        PrintWriter writer = response.getWriter();
        writer.print(json);

    }
}
