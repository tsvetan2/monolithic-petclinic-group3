package org.springframework.samples.petclinic.management;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RevenueRepository extends CrudRepository<RevenueTime, Integer> {

    /**
     * Query reports of revenue.
     */
    @Query("Select new org.springframework.samples.petclinic.management.YearlyRevenue(YEAR(t.visitDate), sum(t.value)) " +
        "from RevenueTime t " +
        "group by YEAR(t.visitDate)")
    List<YearlyRevenue> listYearlyRevenue();

}
