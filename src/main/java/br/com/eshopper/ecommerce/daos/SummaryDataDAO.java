package br.com.eshopper.ecommerce.daos;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.SummaryData;

@Repository
public class SummaryDataDAO {

	@Autowired
	private RedisTemplate<String, SummaryData> redisTemplate;

	public RedisTemplate<String, SummaryData> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, SummaryData> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void save(SummaryData summaryData) {
		this.redisTemplate.opsForHash().put(SummaryData.OBJECT_KEY, summaryData.getPeriod(), summaryData);
	}

	public SummaryData find(String period) {
		return (SummaryData) this.redisTemplate.opsForHash().get(SummaryData.OBJECT_KEY, period);
	}

	public Map<Object, Object> findAll() {
		return this.redisTemplate.opsForHash().entries(SummaryData.OBJECT_KEY);
	}

	public void delete(String period) {
		this.redisTemplate.opsForHash().delete(SummaryData.OBJECT_KEY, period);
	}

}
