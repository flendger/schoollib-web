package org.educationfree.schoollibweb.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.SubjectDto;
import org.educationfree.schoollibweb.model.catalog.Subject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectMapper implements Mapper<Subject, SubjectDto> {
    private final ModelMapper modelMapper;

    @Override
    public SubjectDto entityToDto(Subject entity) {
        return modelMapper.map(entity, SubjectDto.class);
    }

    @Override
    public Subject dtoToEntity(SubjectDto dto) {
        return modelMapper.map(dto, Subject.class);
    }
}
