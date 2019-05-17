package com.bc.lottery.common.cache.redis;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
public enum CacheEnum {
    CAPTHCA("CAPTCHA_KEY", 1L, TimeUnit.MINUTES, "验证码的缓存key"),
    TENANT_ADMIN_LOGIN_SESSION("TENANT_ADMIN_LOGIN_SESSION_KEY", 30L, TimeUnit.MINUTES, "租户管理员登录key");

    // 业务名称
    private String cacheKeyPrefix;
    private long timeout;
    private TimeUnit timeUnit;
    private String description;

    CacheEnum(String cacheKeyPrefix, long timeout, TimeUnit timeUnit, String description) {
        this.cacheKeyPrefix = cacheKeyPrefix;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.description = description;
    }

    private final String separator = "_";

    public String buildCacheKey(String... keySuffix) {
        StringBuilder sb = new StringBuilder(this.cacheKeyPrefix);
        if (keySuffix != null) {
            for (String suffix : keySuffix) {
                sb.append(separator).append(suffix);
            }
        }
        return sb.toString();
    }

}
