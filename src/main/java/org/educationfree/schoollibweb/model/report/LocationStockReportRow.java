package org.educationfree.schoollibweb.model.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.educationfree.schoollibweb.dto.BookDto;
import org.educationfree.schoollibweb.dto.LocationDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationStockReportRow {
    private LocationDto location;
    private BookDto book;
    private int quantity;
}
