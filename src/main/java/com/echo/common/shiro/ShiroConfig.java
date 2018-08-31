package com.echo.common.shiro;

import com.echo.common.shiro.cache.RedisCacheManager;
import com.echo.common.shiro.session.ShiroSessionManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * shiro 相关配置文件
 */
@Configuration
public class ShiroConfig {
    @Autowired
    RedisSessionDao sessionDao;
    @Autowired
    RedisCacheManager cacheManager;

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //set login如果不设置，则会默认寻找Web工程根目录下的/login.jsp页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //静态资源文件可以匿名访问  必须有，否则302错误
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/image/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/signUp", "anon");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //其余接口一律拦截 必须放在最后
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        System.out.println("Shiro拦截器工厂注入成功");
        return shiroFilterFactoryBean;

    }

    /**
     * 加密
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5"); //使用md5算法加密
        hashedCredentialsMatcher.setHashIterations(2); //散列的迭代次数，相当于md5(md5(""))
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);//存储密码是否为16进制
        return hashedCredentialsMatcher;
    }

    /**
     * 安全管理
     *
     * @param shiroRealm
     * @return
     */
    @Bean
    public SecurityManager securityManager(ShiroRealm shiroRealm, DefaultWebSessionManager webSessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        securityManager.setSessionManager(webSessionManager);
        //记住我 rememberme manager还没写
        return securityManager;
    }

    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver
    createSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("DatabaseException", "databaseError");//数据库异常处理
        mappings.setProperty("UnauthorizedException", "403");
        r.setExceptionMappings(mappings);  // None by default
        r.setDefaultErrorView("error");    // No default
        r.setExceptionAttribute("ex");     // Default is "exception"
        //r.setWarnLogCategory("example.MvcLogger");     // No default
        return r;
    }

    @Bean
    public DefaultWebSessionManager configWebSessionManager() {
        DefaultWebSessionManager manager = new DefaultWebSessionManager();
        manager.setCacheManager(cacheManager);// 换成Redis的缓存管理器
        manager.setSessionDAO(sessionDao);
        manager.setDeleteInvalidSessions(true);
        manager.setGlobalSessionTimeout(sessionDao.getExpireTime());
        manager.setSessionValidationSchedulerEnabled(true);

        return manager;
    }


}
