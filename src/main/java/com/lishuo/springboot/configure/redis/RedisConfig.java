package com.lishuo.springboot.configure.redis;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;


/**
 * StringRedisTemplate与RedisTemplate区别点
 * 两者的关系是StringRedisTemplate继承RedisTemplate。
 *
 * 两者的数据是不共通的；也就是说StringRedisTemplate只能管理StringRedisTemplate里面的数据，RedisTemplate只能管理RedisTemplate中的数据。
 *
 * 其实他们两者之间的区别主要在于他们使用的序列化类:
 * 　　　　RedisTemplate使用的是JdkSerializationRedisSerializer    存入数据会将数据先序列化成字节数组然后在存入Redis数据库。
 *
 * 　　 　  StringRedisTemplate使用的是StringRedisSerializer
 *
 * 使用时注意事项：
 * 　　　当你的redis数据库里面本来存的是字符串数据或者你要存取的数据就是字符串类型数据的时候，那么你就使用StringRedisTemplate即可。
 * 　　　但是如果你的数据是复杂的对象类型，而取出的时候又不想做任何的数据转换，直接从Redis里面取出一个对象，那么使用RedisTemplate是更好的选择。
 */
@PropertySource("classpath:application.yml")
@Configuration
@EnableCaching
public class RedisConfig {
    @Bean
    JedisPoolConfig jedisPoolConfig(
            @Value("${redis.pool.maxactive}") int maxActive,
            @Value("${redis.pool.maxidle}") int maxIdle,
            @Value("${redis.pool.minidle}") int minIdle) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        return jedisPoolConfig;
    }

    @Bean(name = "connectionFactory")
    RedisConnectionFactory connectionFactory(JedisPoolConfig poolConfig,
                                             @Value("${redis.host}") String host,
                                             @Value("${redis.port}") int port,
                                             @Value("${redis.timout}") int timeout) {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(
                poolConfig);
        connectionFactory.setHostName(host);
        connectionFactory.setPort(port);
        connectionFactory.setTimeout(timeout);
        connectionFactory.setUsePool(true);
        return connectionFactory;
    }

    //两种reidsTemplate根据场景自由选择
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(@Qualifier("connectionFactory")RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

        //对象内存地址 不需要可以省略
        //ObjectMapper mapper = new ObjectMapper();
        //mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        //serializer.setObjectMapper(mapper);

        template.setValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(@Qualifier("connectionFactory")RedisConnectionFactory connectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(connectionFactory);
        return stringRedisTemplate;
    }
}
