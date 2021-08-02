package org.educationfree.schoollibweb.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntityDto {
    protected Long id;

    protected boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntityDto that = (BaseEntityDto) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "id=" + id +
                '}';
    }
}
