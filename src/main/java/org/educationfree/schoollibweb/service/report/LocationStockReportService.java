package org.educationfree.schoollibweb.service.report;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.BookDto;
import org.educationfree.schoollibweb.dto.LocationDto;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.model.report.LocationStockReportRow;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationStockReportService {
    private final JdbcTemplate jdbcTemplate;
    private final CatalogService<Location, LocationDto> locationService;
    private final CatalogService<Book, BookDto> bookService;

    public List<LocationStockReportRow> getRows() {
        return jdbcTemplate.query(
                "SELECT *\n" +
                        "FROM \n" +
                        "    (SELECT ls.location_id,\n" +
                        "           ls.book_id,\n" +
                        "           SUM(ls.quantity)\n" +
                        "    FROM location_stocks ls\n" +
                        "    GROUP BY location_id,\n" +
                        "             book_id\n" +
                        "    UNION \n" +
                        "    SELECT lssum.location_id,\n" +
                        "           0,\n" +
                        "           SUM(lssum.quantity)\n" +
                        "    FROM location_stocks lssum\n" +
                        "    GROUP BY location_id) res\n" +
                        "ORDER BY location_id, \n" +
                        "         book_id",
                (rs, rowNum) -> {
                    LocationDto location = locationService.findById(rs.getLong(1)).orElseThrow(); //TODO: throw EntityNotFoundException
                    BookDto book = null;
                    long bookId = rs.getLong(2);
                    if (bookId > 0) {
                        book = bookService.findById(bookId).orElseThrow(); //TODO: throw EntityNotFoundException
                    }
                    return new LocationStockReportRow(location, book, rs.getInt(3));
                });
    }
}
