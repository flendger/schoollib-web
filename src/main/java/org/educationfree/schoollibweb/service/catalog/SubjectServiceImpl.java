package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.SubjectDto;
import org.educationfree.schoollibweb.dto.mapper.Mapper;
import org.educationfree.schoollibweb.model.catalog.Subject;
import org.educationfree.schoollibweb.repository.catalog.model.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl extends AbstractCatalogService<Subject, SubjectDto> {
    private final SubjectRepository subjectRepository;
    private final Mapper<Subject, SubjectDto> mapper;

    @Override
    protected SubjectRepository getEntityRepository() {
        return subjectRepository;
    }

    public List<Subject> findSubjectByName(String name) {
       return  subjectRepository.findSubjectByName( name);
    }

    @Override
    protected Mapper<Subject, SubjectDto> getMapper() {
        return mapper;
    }


}
