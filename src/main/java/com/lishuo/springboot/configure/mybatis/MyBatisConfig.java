package com.lishuo.springboot.configure.mybatis;




import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.lishuo.springboot.plugins.VersionInterceptor;

/**
 * MyBatis相关配置.
 *
 * @version 1.0
 * @author bojiangzhou 2018-01-07
 */
@Configuration
public class MyBatisConfig {

    @Bean
    public Interceptor VersionInterceptor(){
        return new VersionInterceptor();
    }
}
