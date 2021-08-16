package org.educationfree.schoollibweb.model.operation.item;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.operation.AbstractOperation;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseItemEntity<T extends AbstractOperation<?>> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(name = "row_num")
    protected Integer row;

    @ManyToOne
    @JoinColumn(name = "doc_id")
    protected T document;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseItemEntity<?> that = (BaseItemEntity<?>) o;

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
