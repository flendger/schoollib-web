package org.educationfree.schoollibweb.dto.operation;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.dto.LocationDto;
import org.educationfree.schoollibweb.dto.operation.item.InventionItemDto;

@Getter
@Setter
public class InventionDto extends AbstractOperationDto<InventionItemDto> {
    private String comment;

    private LocationDto location;
}
