package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.PublisherDto;
import org.educationfree.schoollibweb.dto.mapper.Mapper;
import org.educationfree.schoollibweb.model.catalog.Publisher;
import org.educationfree.schoollibweb.repository.catalog.model.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl extends AbstractCatalogService<Publisher, PublisherDto> {
    private final PublisherRepository publisherRepository;
    private final Mapper<Publisher, PublisherDto> mapper;

    @Override
    protected PublisherRepository getEntityRepository() {
        return publisherRepository;
    }

    @Override
    protected Mapper<Publisher, PublisherDto> getMapper() {
        return mapper;
    }
}
