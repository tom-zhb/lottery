package com.bc.lottery.configuration.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author szl
 *
 */
@SpringBootConfiguration
public class RedisClusterConfig {
	@Autowired
	private RedisClusterConfigProperties clusterProperties;

	@Bean
	public RedisClusterConfiguration getClusterConfig() {
		RedisClusterConfiguration rcc = new RedisClusterConfiguration(clusterProperties.getNodes());
		rcc.setMaxRedirects(clusterProperties.getMaxRedirects().intValue());
		return rcc;
	}

	@Bean
	public JedisConnectionFactory getConnectionFactory(RedisClusterConfiguration cluster) {
		return new JedisConnectionFactory(cluster);
	}


	@Bean
	public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory redisConnectionFactory) {

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new JdkSerializationRedisSerializer());
		template.afterPropertiesSet();

		return template;
	}


	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {

		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		cacheManager.setDefaultExpiration(24L * 60 * 60);
//		cacheManager.setExpires(ImmutableBiMap.of(CachedObjectType.SC_CLASSROOM.getPrefix(), 24L * 60 * 60));
		return cacheManager;
	}
}
