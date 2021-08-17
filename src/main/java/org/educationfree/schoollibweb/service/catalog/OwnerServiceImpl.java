package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.OwnerDto;
import org.educationfree.schoollibweb.dto.mapper.Mapper;
import org.educationfree.schoollibweb.model.catalog.Owner;
import org.educationfree.schoollibweb.repository.catalog.model.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl extends AbstractCatalogService<Owner, OwnerDto> {
    private final OwnerRepository ownerRepository;
    private final Mapper<Owner, OwnerDto> mapper;

    @Override
    protected OwnerRepository getEntityRepository() {
        return ownerRepository;
    }

    @Override
    protected Mapper<Owner, OwnerDto> getMapper() {
        return mapper;
    }
}
