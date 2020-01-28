package org.springframework.samples.petclinic.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagementController {

    @Autowired
    private ManagementService managementService;

    @GetMapping("/management/revenue")
    public List<YearlyRevenue> showRevenue() {
        return managementService.listYearlyRevenue();
    }

}
