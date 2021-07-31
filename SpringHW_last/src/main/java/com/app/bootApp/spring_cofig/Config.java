package com.app.bootApp.spring_cofig;

import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class Config {

    @Bean
    public SimpleCacheManager simpleCacheManager(Set<Cache> caches) {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(caches);

        return simpleCacheManager;
    }

    @Bean(name = "listCache")
    public ConcurrentMapCacheFactoryBean getListCache() {
        return new ConcurrentMapCacheFactoryBean();
    }

    @Bean(name = "singleCache")
    public ConcurrentMapCacheFactoryBean getSingleCache() {
        return new ConcurrentMapCacheFactoryBean();
    }
}
