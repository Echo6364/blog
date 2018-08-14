package com.echo.common.shiro.Service;

import com.echo.project.system.user.domain.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

@Service("passwordEncrypt")
public class PasswordEncrypt {
    //生成随机数
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    public User encrypt(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(algorithmName, user.getLoginPassword(), ByteSource.Util.bytes(user.getSalt()), hashIterations).toHex();
        user.setLoginPassword(newPassword);
        return user;
    }

    public String md5Pwd(String loginPassword, String salt) {
        String md5Pwd = new SimpleHash("MD5", loginPassword, ByteSource.Util.bytes(salt), hashIterations).toHex();
        return md5Pwd;
    }

    private final String algorithmName = "MD5";
    private final int hashIterations = 2;
}
