package org.educationfree.schoollibweb.dto.operation;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.dto.LocationDto;
import org.educationfree.schoollibweb.dto.PublisherDto;
import org.educationfree.schoollibweb.dto.operation.item.ReceiptFromPublisherItemDto;

@Getter
@Setter
public class ReceiptFromPublisherDto extends AbstractOperationDto<ReceiptFromPublisherItemDto> {
    private String comment;

    private PublisherDto publisher;

    private LocationDto location;
}
