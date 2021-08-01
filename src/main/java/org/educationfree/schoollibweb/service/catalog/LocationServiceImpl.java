package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.repository.catalog.model.LocationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl extends AbstractCatalogService<Location> {
    private final LocationRepository locationRepository;

    @Override
    protected LocationRepository getEntityRepository() {
        return locationRepository;
    }
}
