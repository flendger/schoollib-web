package org.educationfree.schoollibweb.dto.operation.item;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.dto.operation.AbstractOperationDto;

@Getter
@Setter
public abstract class BaseItemEntityDto<T extends AbstractOperationDto<?>> {
    protected Long id;

    protected Integer row;

    protected T document;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseItemEntityDto<?> that = (BaseItemEntityDto<?>) o;

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
