package org.educationfree.schoollibweb.repository.catalog.model;

import org.educationfree.schoollibweb.model.catalog.Subject;
import org.educationfree.schoollibweb.repository.catalog.CatalogRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CatalogRepository<Subject> {
    @Query(" update Subject t   " +
            "set t.isDeleted= 'true'" +
            "where t.id = :id ")
    void setDeletedById(@Param("id") String id);
}
