package org.educationfree.schoollibweb.service.catalog;

import org.educationfree.schoollibweb.dto.AbstractCatalogDto;
import org.educationfree.schoollibweb.dto.mapper.Mapper;
import org.educationfree.schoollibweb.model.catalog.AbstractCatalog;
import org.educationfree.schoollibweb.repository.catalog.CatalogRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public abstract class AbstractCatalogService<T extends AbstractCatalog, D extends AbstractCatalogDto> implements CatalogService<T,D> {

    protected abstract CatalogRepository<T> getEntityRepository();
    protected abstract Mapper<T,D> getMapper();

    @Override
    public List<D> findAll() {
        return getEntityRepository().findAll().stream().map(t -> getMapper().entityToDto(t)).collect(Collectors.toList());
    }

    @Override
    public List<D> findAllByIsDeletedFalse() {

        return getEntityRepository().findAllByIsDeletedFalse()
                .stream().map(t -> getMapper().entityToDto(t)).collect(Collectors.toList());
    }

    @Override
    public Optional<D> findById(Long id) {
        Optional<T> entity = getEntityRepository().findById(id);
        return entity.isEmpty() ? Optional.empty() : Optional.of(getMapper().entityToDto(entity.get()));
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public D save(D entity) {
        if (entity.getId() == null && entity.getCode() == null) {
            D last = findLast().orElse(null);
            if (last == null) {
                //first element in catalog
                entity.setCode(1);
            } else {
                entity.setCode(last.getCode() + 1);
            }
        }
        return getMapper().entityToDto(getEntityRepository().save(getMapper().dtoToEntity(entity)));
    }

    @Override
    public void delete(D dtoEntity) {
        getEntityRepository().delete(getMapper().dtoToEntity(dtoEntity));
    }

    @Override
    public void deleteById(Long id) {
        getEntityRepository().deleteById(id);
    }

    @Override
    public Optional<D> findLast() {
        Optional<T> entity = getEntityRepository().findTopByOrderByCodeDesc();
        return entity.isEmpty() ? Optional.empty() : Optional.of(getMapper().entityToDto(entity.get()));
    }

    @Override
    @Transactional
    public void setDeleted(Long id, boolean isDeleted) throws EntityNotFoundException {
        CatalogRepository<T> repository = getEntityRepository();
        T entity = repository.getById(id);
        entity.setDeleted(isDeleted);
        repository.save(entity);
    }
}
