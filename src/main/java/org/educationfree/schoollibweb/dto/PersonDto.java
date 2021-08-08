package org.educationfree.schoollibweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDto extends AbstractCatalogDto {
    private String telephone;

    private String email;

    private String address;

    private String comment;

    public PersonDto(Long id, boolean isDeleted, Integer code, String name, String telephone, String email, String address, String comment) {
        super(id, isDeleted, code, name);
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.comment = comment;
    }
}
