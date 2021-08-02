package org.educationfree.schoollibweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublisherDto extends AbstractCatalogDto {
    public PublisherDto(Long id, boolean isDeleted, Integer code, String name) {
        super(id, isDeleted, code, name);
    }
}
