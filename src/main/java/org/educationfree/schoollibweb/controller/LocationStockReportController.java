package org.educationfree.schoollibweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/location_stock_report")
public class LocationStockReportController {

    @GetMapping
    public String getReport() {
        return "location_stock_report";
    }
}
