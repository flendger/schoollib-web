package org.educationfree.schoollibweb.repository;

import org.educationfree.schoollibweb.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface EntityRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
    List<T> findAllByIsDeletedFalse();


}