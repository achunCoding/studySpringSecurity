package top.wycfight.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: wycfight@163.com
 * @description: 自定义密码加密
 * @create: 2019-08-04 10:59
 * @modify By:
 **/
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
