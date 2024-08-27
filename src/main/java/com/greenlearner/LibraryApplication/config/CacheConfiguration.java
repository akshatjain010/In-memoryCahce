/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.greenlearner.LibraryApplication.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Lenovo
 */
@Configuration
public class CacheConfiguration {
    
    private static final Logger logger= LoggerFactory.getLogger(CacheConfiguration.class);
    
    @Bean
    CacheManagerCustomizer<ConcurrentMapCacheManager> customizer() {
        return new ConcurrentCustomizer();
    }
    
    class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

        @Override
        public void customize(ConcurrentMapCacheManager cacheManager) {
            cacheManager.setAllowNullValues(false);
            cacheManager.setStoreByValue(true);
            logger.info("customizer invoked!");
        }
        
    }
}
