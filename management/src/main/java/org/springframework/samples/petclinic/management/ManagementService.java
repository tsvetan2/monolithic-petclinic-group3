package org.springframework.samples.petclinic.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ManagementService {

    @Autowired
    private RevenueRepository revenueRepository;

    public List<YearlyRevenue> listYearlyRevenue() {
        return revenueRepository.listYearlyRevenue();
    }

    public void saveRevenue(Integer sourceId, LocalDate visitDate, Integer value) {
        RevenueTime revenueTime = new RevenueTime();
        revenueTime.setSourceId(sourceId);
        revenueTime.setVisitDate(visitDate);
        revenueTime.setValue(value);

        revenueRepository.save(revenueTime);
    }
}
