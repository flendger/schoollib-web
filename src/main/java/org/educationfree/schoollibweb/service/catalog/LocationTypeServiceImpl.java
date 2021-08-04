package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.LocationType;
import org.educationfree.schoollibweb.repository.catalog.model.LocationTypeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationTypeServiceImpl extends AbstractCatalogService<LocationType> {
    private final LocationTypeRepository locationTypeRepository;

    @Override
    protected LocationTypeRepository getEntityRepository() {
        return locationTypeRepository;
    }
}
