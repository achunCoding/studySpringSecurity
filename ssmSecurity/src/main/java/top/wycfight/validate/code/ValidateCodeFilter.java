package top.wycfight.validate.code;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;
import top.wycfight.controller.ValidateController;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: wycfight@163.com
 * @description: 验证码校验的过滤器
 * @create: 2019-08-11 20:48
 * @modify By:
 **/
public class ValidateCodeFilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler authenticationFailureHandler;

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (StringUtils.equalsIgnoreCase("/userLogin", httpServletRequest.getRequestURI()) &&
                StringUtils.equalsIgnoreCase(httpServletRequest.getMethod(), "post")) {
            try {
                validateCode((ServletWebRequest) httpServletRequest);
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            }
        }

    }

    /**
     * 校验验证码
     * @param servletWebRequest
     * @throws ServletRequestBindingException
     * @throws ValidateCodeException
     */
    private void validateCode(ServletWebRequest servletWebRequest) throws ServletRequestBindingException, ValidateCodeException {
        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(servletWebRequest, ValidateController.SESSION_KEY_IMAGE_CODE);
        String codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(), "imageCode");

        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码不能为空！");
        }
        if (codeInSession == null) {
            throw new ValidateCodeException("验证码不存在！");
        }
        if (codeInSession.isExpire()) {
            sessionStrategy.removeAttribute(servletWebRequest, ValidateController.SESSION_KEY_IMAGE_CODE);
            throw new ValidateCodeException("验证码已过期！");
        }
        if (!StringUtils.equalsIgnoreCase(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不正确！");
        }
        sessionStrategy.removeAttribute(servletWebRequest, ValidateController.SESSION_KEY_IMAGE_CODE);

    }
}
