package org.educationfree.schoollibweb.dto.mapper;

public interface Mapper<E,D> {
    D entityToDto(E entity);
    E dtoToEntity(D dto);
}
