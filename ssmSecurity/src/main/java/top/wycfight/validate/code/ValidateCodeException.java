package top.wycfight.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author: wycfight@163.com
 * @description: 验证码异常处理类
 * @create: 2019-08-11 20:44
 * @modify By:
 **/
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String detail) {
        super(detail);
    }
}
