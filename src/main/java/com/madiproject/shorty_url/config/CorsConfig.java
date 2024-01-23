package com.madiproject.shorty_url.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private static final String[] ALLOWED_ORIGINS = {"*"};
    private static final String[] ALLOWED_METHODS = {"GET", "POST"};

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        configureGlobalCorsMappings(registry);
    }

    private void configureGlobalCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(ALLOWED_ORIGINS)
                .allowedMethods(ALLOWED_METHODS);
    }
}
