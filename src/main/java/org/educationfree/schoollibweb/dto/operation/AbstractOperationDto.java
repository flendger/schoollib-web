package org.educationfree.schoollibweb.dto.operation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.educationfree.schoollibweb.dto.BaseEntityDto;
import org.educationfree.schoollibweb.dto.operation.item.BaseItemEntityDto;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractOperationDto<I extends BaseItemEntityDto<?>> extends BaseEntityDto {
    protected Integer docNumber;

    protected LocalDateTime docDate;

    protected List<I> items;
}
