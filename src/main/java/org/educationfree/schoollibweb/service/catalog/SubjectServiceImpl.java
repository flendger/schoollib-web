package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Subject;
import org.educationfree.schoollibweb.repository.catalog.model.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl extends AbstractCatalogService<Subject> {
    private final SubjectRepository subjectRepository;

    @Override
    protected SubjectRepository getEntityRepository() {
        return subjectRepository;
    }
}
