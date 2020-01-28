package org.springframework.samples.petclinic.management;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.management.YearlyRevenue;

import java.util.List;

/**
 * Query reports of revenue.
 */
public interface RevenueRepository extends Repository<RevenueTime, Integer> {

    @Query("Select new org.springframework.samples.petclinic.management.YearlyRevenue(YEAR(t.visitDate), sum(t.value)) " +
        "from RevenueTime t " +
        "group by YEAR(t.visitDate)")
    List<YearlyRevenue> listYearlyRevenue();

}
