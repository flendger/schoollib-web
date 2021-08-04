package org.educationfree.schoollibweb.config;

import org.educationfree.schoollibweb.dto.BookDto;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
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
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Book, BookDto>() {
            @Override
            protected void configure() {
                when(ctx -> ctx.getSource() == null ).skip(source.getBookType(),destination.getBookTypeDto());
                when(ctx -> ctx.getSource() == null ).skip(source.getOwner(),destination.getOwnerDto());
                when(ctx -> ctx.getSource() == null ).skip(source.getPublisher(),destination.getPublisherDto());
                when(ctx -> ctx.getSource() == null ).skip(source.getSubject(),destination.getSubjectDto());
            }
        });
        modelMapper.addMappings(new PropertyMap<BookDto, Book>() {
            @Override
            protected void configure() {
                when(ctx -> ctx.getSource() == null ).skip(source.getBookTypeDto(),destination.getBookType());
                when(ctx -> ctx.getSource() == null ).skip(source.getOwnerDto(),destination.getOwner());
                when(ctx -> ctx.getSource() == null ).skip(source.getPublisherDto(),destination.getPublisher());
                when(ctx -> ctx.getSource() == null ).skip(source.getSubjectDto(),destination.getSubject());
            }
        });
        return modelMapper;
    }
}