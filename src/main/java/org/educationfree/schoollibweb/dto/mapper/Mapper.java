package org.educationfree.schoollibweb.dto.mapper;

public interface Mapper<E,D> {
    D EntityToDto(E entity);
    E DtoToEntity(D dto);
}
