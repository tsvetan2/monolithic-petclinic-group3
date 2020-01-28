package org.springframework.samples.petclinic.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

//@Controller
public class ManagementController {

    @Autowired
    private ManagementService managementService;

//    @GetMapping("/management/revenue")
//    public String showRevenue(Map<String, Object> model) {
//        model.put("revenues", managementService.listYearlyRevenue());
//        return "management/showRevenue";
//    }

}
