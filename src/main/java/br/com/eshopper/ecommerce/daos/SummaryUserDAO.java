package br.com.eshopper.ecommerce.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.SummaryUser;

@Repository
public class SummaryUserDAO {
	
	@Autowired
	private RedisTemplate<String, SummaryUser> redisTemplate;
	
	public RedisTemplate<String, SummaryUser> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, SummaryUser> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void save(SummaryUser summaryData) {
		this.redisTemplate.opsForHash().put(SummaryUser.OBJECT_KEY, SummaryUser.OBJECT_ID, summaryData);
	}

	public SummaryUser find() {
		return (SummaryUser) this.redisTemplate.opsForHash().get(SummaryUser.OBJECT_KEY, SummaryUser.OBJECT_ID);
	}

	public void delete() {
		this.redisTemplate.opsForHash().delete(SummaryUser.OBJECT_KEY, SummaryUser.OBJECT_ID);
	}
	
}
