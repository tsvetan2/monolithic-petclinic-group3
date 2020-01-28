package org.springframework.samples.petclinic.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ManagementServiceLocal implements ManagementService {

    @Autowired
    private RevenueRepository revenueRepository;

    @Override
    public List<YearlyRevenue> listYearlyRevenue() {
        return revenueRepository.listYearlyRevenue();
    }

    @Override
    public void saveRevenue(int sourceId, LocalDate visitDate, long cost) {
        RevenueTime revenueTime = new RevenueTime();
        revenueTime.setSourceId(sourceId);
        revenueTime.setVisitDate(visitDate);
        revenueTime.setValue(cost);
        revenueRepository.save(revenueTime);
    }
}
