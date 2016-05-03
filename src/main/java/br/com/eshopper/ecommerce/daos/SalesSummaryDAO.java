package br.com.eshopper.ecommerce.daos;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.eshopper.ecommerce.models.SalesSummary;

@Repository
public class SalesSummaryDAO {

	@Autowired
	private RedisTemplate<String, SalesSummary> redisTemplate;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public RedisTemplate<String, SalesSummary> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, SalesSummary> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void save(SalesSummary summaryData) {
		this.redisTemplate.opsForHash().put(SalesSummary.OBJECT_KEY, summaryData.getPeriod(), summaryData);
	}
	
	public SalesSummary find(String period) {
		Object json = this.redisTemplate.opsForHash().get(SalesSummary.OBJECT_KEY, period);
		return mapper.convertValue(json, SalesSummary.class);
	}

	public Map<Object, Object> findAll() {
		return this.redisTemplate.opsForHash().entries(SalesSummary.OBJECT_KEY);
	}

	public void delete(String period) {
		this.redisTemplate.opsForHash().delete(SalesSummary.OBJECT_KEY, period);
	}

}
