package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.service.report.LocationStockReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/location_stock_report")
@RequiredArgsConstructor
public class LocationStockReportController {
    private final LocationStockReportService reportService;

    @GetMapping
    public String getReport(Model model) {
        model.addAttribute("report_rows", reportService.getRows());
        return "location_stock_report";
    }
}
