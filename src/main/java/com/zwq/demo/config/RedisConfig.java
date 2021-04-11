package com.zwq.demo.config;

import com.zwq.demo.dto.RedisConst;
import lombok.Data;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


@Data
@Component
@Configuration
//@EnableCaching // 开启缓存支持
@EnableConfigurationProperties(RedisConst.class)
public class RedisConfig extends CachingConfigurerSupport {

    @Autowired
    private RedisConst redisConst;

//    @Value("${spring.redis.cache.nodes:}")
//    private String nodes;
//    @Value("${spring.redis.cache.host}")
    private String host = "192.168.96.128";
    private String port ="6379";
    private String password="6993258";
//    private String host;
//    private String port ;
//    private String password;
//    @Value("${spring.redis.cache.password:}")
//    @Value("${spring.redis.cache.maxIdle:}")
    private Integer maxIdle;
//    @Value("${spring.redis.cache.minIdle:}")
    private Integer minIdle;
//    @Value("${spring.redis.cache.maxTotal:}")
    private Integer maxTotal;
//    @Value("${spring.redis.cache.maxWaitMillis:}")
    private Long maxWaitMillis;


    @Resource
    private LettuceConnectionFactory lettuceConnectionFactory;

    @Bean
    LettuceConnectionFactory lettuceConnectionFactory() {
//        String host = redisConst.getHost();
//        System.out.println(host);

        // 连接池配置
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(maxIdle == null ? 8 : maxIdle);
        poolConfig.setMinIdle(minIdle == null ? 1 : minIdle);
        poolConfig.setMaxTotal(maxTotal == null ? 8 : maxTotal);
        poolConfig.setMaxWaitMillis(maxWaitMillis == null ? 5000L : maxWaitMillis);
        LettucePoolingClientConfiguration lettucePoolingClientConfiguration = LettucePoolingClientConfiguration.builder()
                .poolConfig(poolConfig)
                .build();
        // 单机redis
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        System.out.println("哈哈哈哈:host Is:"+ this.host);
        System.out.println("哈哈哈哈:port Is:"+ port);

//        redisConfig.setHostName(host==null||"".equals(host)?"localhost":host.split(":")[0]);
//        redisConfig.setPort(Integer.valueOf(host==null||"".equals(host)?"6379":host.split(":")[1]));
        redisConfig.setHostName(this.host);
        redisConfig.setPort(Integer.valueOf(port));

        if (password != null && !"".equals(password)) {
            redisConfig.setPassword(password);
        }

        // 哨兵redis
        // RedisSentinelConfiguration redisConfig = new RedisSentinelConfiguration();

        // 集群redis
        /*RedisClusterConfiguration redisConfig = new RedisClusterConfiguration();
        Set<RedisNode> nodeses = new HashSet<>();
        String[] hostses = nodes.split("-");
        for (String h : hostses) {
            h = h.replaceAll("\\s", "").replaceAll("\n", "");
            if (!"".equals(h)) {
                String host = h.split(":")[0];
                int port = Integer.valueOf(h.split(":")[1]);
                nodeses.add(new RedisNode(host, port));
            }
        }
        redisConfig.setClusterNodes(nodeses);
        // 跨集群执行命令时要遵循的最大重定向数量
        redisConfig.setMaxRedirects(3);
        redisConfig.setPassword(password);*/

        return new LettuceConnectionFactory(redisConfig, lettucePoolingClientConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(lettuceConnectionFactory);
        //序列化类
        MyRedisSerializer myRedisSerializer = new MyRedisSerializer();
        //key序列化方式
        template.setKeySerializer(myRedisSerializer);
        //value序列化
        template.setValueSerializer(myRedisSerializer);
        //value hashmap序列化
        template.setHashValueSerializer(myRedisSerializer);
        return template;
    }

    static class MyRedisSerializer implements RedisSerializer<Object> {

        @Override
        public byte[] serialize(Object o) throws SerializationException {
            return serializeObj(o);
        }

        @Override
        public Object deserialize(byte[] bytes) throws SerializationException {
            return deserializeObj(bytes);
        }

        /**
         * 序列化
         * @param object
         * @return
         */
        private static byte[] serializeObj(Object object) {
            ObjectOutputStream oos = null;
            ByteArrayOutputStream baos = null;
            try {
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(object);
                byte[] bytes = baos.toByteArray();
                return bytes;
            } catch (Exception e) {
                throw new RuntimeException("序列化失败!", e);
            }
        }

        /**
         * 反序列化
         * @param bytes
         * @return
         */
        private static Object deserializeObj(byte[] bytes) {
            if (bytes == null){
                return null;
            }
            ByteArrayInputStream bais = null;
            try {
                bais = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bais);
                return ois.readObject();
            } catch (Exception e) {
                throw new RuntimeException("反序列化失败!", e);
            }
        }
    }

}
