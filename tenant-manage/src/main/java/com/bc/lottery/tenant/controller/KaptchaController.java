package com.bc.lottery.tenant.controller;

import com.bc.lottery.common.cache.redis.CacheEnum;
import com.bc.lottery.common.cache.redis.RedisUtils;
import com.bc.lottery.common.core.api.R;
import com.bc.lottery.common.util.TokenUtils;
import com.bc.lottery.tenant.exception.CaptchaException;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(maxAge = 60 * 60 * 24)
@RestController
@RequestMapping("/captcha")
public class KaptchaController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @Autowired
    RedisUtils redisUtils;

    /**
     * 生成验证码
     * @throws Exception
     */
    @GetMapping("/code")
    public R<Map<String, String>> geneCaptchaCode() throws CaptchaException {
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 生产验证码字符串并保存到session中
            String captchaCode = defaultKaptcha.createText();
            String captchaToken = TokenUtils.generateValue();
            redisUtils.setEx(CacheEnum.CAPTHCA.buildCacheKey(captchaToken), captchaCode,
                                                             CacheEnum.CAPTHCA.getTimeout(), CacheEnum.CAPTHCA.getTimeUnit());
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(captchaCode);
            ImageIO.write(challenge, "jpg", jpegOutputStream);

            byte[] bytes = jpegOutputStream.toByteArray();

            Map<String, String> data = new HashMap<>();
            data.put("captchaImg", new BASE64Encoder().encodeBuffer(bytes).trim());
            data.put("captchaToken", captchaToken);
            return R.data(data);
        } catch (Exception e) {
            throw new CaptchaException();
        }

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
       /* captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();*/
    }

    /**
     * 校对验证码
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @RequestMapping("/check")
    public ModelAndView checkCaptchaCode(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse) {
        ModelAndView andView = new ModelAndView();
        String rightCode = (String) httpServletRequest.getSession().getAttribute("rightCode");
        String tryCode = httpServletRequest.getParameter("tryCode");
        System.out.println("rightCode:" + rightCode + " ———— tryCode:" + tryCode);
        if (!rightCode.equals(tryCode)) {
            andView.addObject("info", "错误的验证码");
            andView.setViewName("index");
        } else {
            andView.addObject("info", "登录成功");
            andView.setViewName("success");
        }
        return andView;
    }

}