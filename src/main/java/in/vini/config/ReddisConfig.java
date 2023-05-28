package in.vini.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.vini.binding.Country;

@Configuration
public class ReddisConfig {
	@Bean
	public JedisConnectionFactory jedisCon() {
		JedisConnectionFactory jeddis = new JedisConnectionFactory();
		return jeddis;
	}

	@Bean
	public RedisTemplate<String, Country> redisTemplate() {
		RedisTemplate<String, Country> rt = new RedisTemplate<>();
		rt.setConnectionFactory(jedisCon());
		return rt;
	}
}
