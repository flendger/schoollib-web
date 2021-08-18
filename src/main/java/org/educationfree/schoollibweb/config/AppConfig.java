package org.educationfree.schoollibweb.config;

import org.educationfree.schoollibweb.dto.BookDto;
import org.educationfree.schoollibweb.dto.LocationDto;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.catalog.Location;
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
                when(ctx -> ctx.getSource() == null ).skip(source.getBookType(),destination.getBookType());
                when(ctx -> ctx.getSource() == null ).skip(source.getOwner(),destination.getOwner());
                when(ctx -> ctx.getSource() == null ).skip(source.getPublisher(),destination.getPublisher());
                when(ctx -> ctx.getSource() == null ).skip(source.getSubject(),destination.getSubject());
            }
        });
        modelMapper.addMappings(new PropertyMap<BookDto, Book>() {
            @Override
            protected void configure() {
                when(ctx -> ctx.getSource() == null ).skip(source.getBookType(),destination.getBookType());
                when(ctx -> ctx.getSource() == null ).skip(source.getOwner(),destination.getOwner());
                when(ctx -> ctx.getSource() == null ).skip(source.getPublisher(),destination.getPublisher());
                when(ctx -> ctx.getSource() == null ).skip(source.getSubject(),destination.getSubject());
            }
        });
        modelMapper.addMappings(new PropertyMap<Location, LocationDto>() {
            @Override
            protected void configure() {
                when(ctx -> ctx.getSource() == null ).skip(source.getLocationType(),destination.getLocationType());
                when(ctx -> ctx.getSource() == null ).skip(source.getPerson(),destination.getPerson());
            }
        });
        modelMapper.addMappings(new PropertyMap<LocationDto, Location>() {
            @Override
            protected void configure() {
                when(ctx -> ctx.getSource() == null ).skip(source.getLocationType(),destination.getLocationType());
                when(ctx -> ctx.getSource() == null ).skip(source.getPerson(),destination.getPerson());
            }
        });
        return modelMapper;
    }
}