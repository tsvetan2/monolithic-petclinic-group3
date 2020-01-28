package org.springframework.samples.petclinic.management;

import java.time.LocalDate;
import java.util.List;

public interface ManagementService {
    List<YearlyRevenue> listYearlyRevenue();
    void saveRevenue(int sourceId, LocalDate visitDate, long cost);
}
