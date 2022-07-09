package com.practice.service.controllers;

import com.practice.service.dao.DayCurrencyDAO;
import com.practice.service.model.DayCurrency;
import com.practice.service.services.DayCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class DayCurrencyController {
    private final DayCurrencyService dayCurrencyService;

    @Autowired
    public DayCurrencyController(DayCurrencyService dayCurrencyService) {
        this.dayCurrencyService = dayCurrencyService;
    }

    @GetMapping(value = "/period-currencies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DayCurrency> getCurrenciesForPeriod(@RequestParam(name="fromDate") Date fromDate,
                                                    @RequestParam(name="toDate") Date toDate,
                                                    @RequestParam(name="curName") String currencyName) {
        return dayCurrencyService.getPeriodCurrencies(fromDate, toDate, currencyName);
    }

//    @GetMapping(value = "/testDB", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String testDB() {
//        dayCurrencyService.insert(new DayCurrency(444, 77.77, new Date(1999, 12, 12), 100, "pk33"), "Евро");
//        return "testDB";
//    }
}
