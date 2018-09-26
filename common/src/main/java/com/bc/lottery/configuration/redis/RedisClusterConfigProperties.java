package com.bc.lottery.configuration.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangdezhen@vipkid.com.cn
 *
 */
@Component
@ConfigurationProperties(prefix = "redis.cluster")
public class RedisClusterConfigProperties {
    /**
     * master nodes
     */
    private List<String> nodes;

    /**
     * max redirects
     */
    private Integer maxRedirects = 3;

	public List<String> getNodes() {
		return nodes;
	}

	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}

	public Integer getMaxRedirects() {
		return maxRedirects;
	}

	public void setMaxRedirects(Integer maxRedirects) {
		this.maxRedirects = maxRedirects;
	}
    
    
}