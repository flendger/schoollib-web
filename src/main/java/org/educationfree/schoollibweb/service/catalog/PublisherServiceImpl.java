package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Publisher;
import org.educationfree.schoollibweb.repository.catalog.model.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl extends AbstractCatalogService<Publisher> {
    private final PublisherRepository publisherRepository;

    @Override
    protected PublisherRepository getEntityRepository() {
        return publisherRepository;
    }
}
