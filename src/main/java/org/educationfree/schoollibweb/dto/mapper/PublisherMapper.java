package org.educationfree.schoollibweb.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.PublisherDto;
import org.educationfree.schoollibweb.model.catalog.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublisherMapper implements Mapper<Publisher, PublisherDto> {
    private final ModelMapper modelMapper;

    @Override
    public PublisherDto entityToDto(Publisher entity) {
        return modelMapper.map(entity, PublisherDto.class);
    }

    @Override
    public Publisher dtoToEntity(PublisherDto dto) {
        return modelMapper.map(dto, Publisher.class);
    }
}
