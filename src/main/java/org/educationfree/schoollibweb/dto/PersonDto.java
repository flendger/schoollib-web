package org.educationfree.schoollibweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonDto extends AbstractCatalogDto {
    private String telephone;

    private String email;

    private String address;

    private String comment;

    public PersonDto(Long id, boolean isDeleted, Integer code, String name) {
        super(id, isDeleted, code, name);
    }
}
