package com.lishuo.springboot.configure.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@PropertySource(value = "classpath:application.yml")
public class CoreConfig {
}
