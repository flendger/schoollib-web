package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.LocationDto;
import org.educationfree.schoollibweb.dto.mapper.Mapper;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.repository.catalog.model.LocationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl extends AbstractCatalogService<Location, LocationDto> {
    private final LocationRepository locationRepository;
    private final Mapper<Location, LocationDto> mapper;
    @Override
    protected LocationRepository getEntityRepository() {
        return locationRepository;
    }

    @Override
    protected Mapper<Location, LocationDto> getMapper() {
        return mapper;
    }
}
