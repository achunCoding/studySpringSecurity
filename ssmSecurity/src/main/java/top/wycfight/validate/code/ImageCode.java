package top.wycfight.validate.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author: wycfight@163.com
 * @description: 验证码对象
 * @create: 2019-08-11 20:12
 * @modify By:
 **/
@Getter
@Setter
@AllArgsConstructor
public class ImageCode {
    /**
     * 验证码图片
     */
    private BufferedImage bufferedImage;
    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 设置验证码的有效期
     * @param bufferedImage 验证码图片
     * @param code 验证码
     * @param expireIn 有效时长：秒
     */
    public ImageCode(BufferedImage bufferedImage, String code, int expireIn) {
        this.bufferedImage = bufferedImage;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
