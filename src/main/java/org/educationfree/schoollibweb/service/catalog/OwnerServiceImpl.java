package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Owner;
import org.educationfree.schoollibweb.repository.catalog.model.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl extends AbstractCatalogService<Owner> {
    private final OwnerRepository ownerRepository;

    @Override
    protected OwnerRepository getEntityRepository() {
        return ownerRepository;
    }
}
