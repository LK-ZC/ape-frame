package com.jingdianjichi.user.cache;

import com.jingdianjichi.redis.init.AbstractCache;
import com.jingdianjichi.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoryCache extends AbstractCache {

    private static final String CATEGORY_CACHE_KEY = "CATEGORY";

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void initCache() {
        //跟数据库做联动了，跟其他的数据来源进行联动
        redisUtil.set("category","知识");
    }

    @Override
    public <T> T getCache(String key) {
        if(!redisTemplate.hasKey(key).booleanValue()){
            reloadCache();
        }
        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void clearCache() {
        redisTemplate.delete(CATEGORY_CACHE_KEY);
    }
}
