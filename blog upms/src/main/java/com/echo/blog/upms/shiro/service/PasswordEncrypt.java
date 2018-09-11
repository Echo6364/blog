package com.echo.blog.upms.shiro.service;

import com.echo.blog.upms.user.domain.UpmsUser;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

@Service("passwordEncrypt")
public class PasswordEncrypt {
    //生成随机数
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private final String algorithmName = "MD5";
    private final int hashIterations = 2;

    public UpmsUser encrypt(UpmsUser upmsUser) {
        upmsUser.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(algorithmName, upmsUser.getLoginPassword(), ByteSource.Util.bytes(upmsUser.getCredentialsSalt()), hashIterations).toHex();
        upmsUser.setLoginPassword(newPassword);
        return upmsUser;
    }

    public String md5Pwd(String loginPassword, String salt) {
        String md5Pwd = new SimpleHash("MD5", loginPassword, ByteSource.Util.bytes(salt), hashIterations).toHex();
        return md5Pwd;
    }
}
