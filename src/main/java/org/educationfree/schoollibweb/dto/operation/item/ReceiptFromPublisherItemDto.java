package org.educationfree.schoollibweb.dto.operation.item;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.dto.BookDto;
import org.educationfree.schoollibweb.dto.operation.ReceiptFromPublisherDto;

@Getter
@Setter
public class ReceiptFromPublisherItemDto extends BaseItemEntityDto<ReceiptFromPublisherDto> {
    private BookDto book;

    private int quantity;
}
