package com.wsu.workorderproservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * This CorsConfig class created to allow cross-origin resource sharing from web application
 */
@Configuration
public class CorsConfig {

    /**
     * This method used to apply Cross-origin resource sharing configuration (e.g. allowed headers, methods, origin pattern, credentials)
     * to allow endpoint access from web application
     * @return - CorsFilter with applied configurations
     */
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
