package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.LocationTypeDto;
import org.educationfree.schoollibweb.dto.mapper.Mapper;
import org.educationfree.schoollibweb.model.catalog.LocationType;
import org.educationfree.schoollibweb.repository.catalog.model.LocationTypeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationTypeServiceImpl extends AbstractCatalogService<LocationType, LocationTypeDto> {
    private final LocationTypeRepository locationTypeRepository;
    private final Mapper<LocationType, LocationTypeDto> mapper;
    @Override
    protected LocationTypeRepository getEntityRepository() {
        return locationTypeRepository;
    }

    @Override
    protected Mapper<LocationType, LocationTypeDto> getMapper() {
        return mapper;
    }
}
