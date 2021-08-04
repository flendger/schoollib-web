package org.educationfree.schoollibweb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/static/dist/**").addResourceLocations("classpath:/static/dist/");
            registry.addResourceHandler("/static/vendors/**").addResourceLocations("classpath:/static/vendors/");
        }
    }

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}