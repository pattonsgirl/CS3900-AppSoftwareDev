package com.wsu.workorderproservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * This CorsConfig class created to allow cross-origin resource sharing from web application
 */
//@Configuration annotation in the Spring Framework indicates that a class is a source of bean definitions for the Spring IoC container
@Configuration
public class CorsConfig {

    /**
     * This method used to apply Cross-origin resource sharing configuration (e.g. allowed headers, methods, origin pattern, credentials)
     * to allow endpoint access from web application
     * @return - CorsFilter with applied configurations
     */
    //@Bean annotation in Spring is used to explicitly declare a bean that will be managed by the Spring IoC container
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*");
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
