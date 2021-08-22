package org.educationfree.schoollibweb.dto.operation.item;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.dto.BookDto;
import org.educationfree.schoollibweb.dto.operation.InventionDto;

@Getter
@Setter
public class InventionItemDto extends BaseItemEntityDto<InventionDto> {
    private BookDto book;

    private int quantity;
}
