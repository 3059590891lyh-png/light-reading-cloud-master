package cn.zealon.readingcloud.account.common.utils;

import cn.zealon.readingcloud.account.vo.UserVO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import static cn.zealon.readingcloud.common.constant.JwtConstant.SECRET_KEY;

/**
 * JWT工具
 * @author: zealon
 * @since: 2020/4/14
 */
public class JwtUtil {
//    // 使用足够长度的密钥
//    private static final String SECRET_KEY = "your-secure-key-with-at-least-32-characters-for-hs256-algorithm";

    // 或者使用JWT库提供的安全密钥生成方法
//    private static final SecretKey SECURE_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * 构建JWT对象
     * @param expire
     * @param user
     * @return
     */
    public static String buildJwt(Date expire, UserVO user) {
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)  // 使用安全密钥
                .setExpiration(expire)
                .claim("loginName", user.getLoginName())
                .claim("nickName", user.getNickName())
                .claim("phoneNumber", user.getPhoneNumber())
                .claim("headImgUrl", user.getHeadImgUrl())
                .claim("uuid", user.getUuid())
                .claim("id", user.getId())
                .compact();
        return jwt;
    }
}
