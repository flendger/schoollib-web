package org.educationfree.schoollibweb.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractCatalogDto extends BaseEntityDto {
    protected Integer code;

    protected String name;

    public AbstractCatalogDto(Long id, boolean isDeleted, Integer code, String name) {
        super(id, isDeleted);
        this.code = code;
        this.name = name;
    }

}
