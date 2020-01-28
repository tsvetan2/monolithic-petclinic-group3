package org.springframework.samples.petclinic.management;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.management.YearlyRevenue;

import java.util.List;

/**
 * Query reports of revenue.
 */
public interface RevenueRepository { // extends Repository<Visit, Integer> {

/*
    @Query("Select new org.springframework.samples.petclinic.management.YearlyRevenue(YEAR(v.date), sum(v.cost)) " +
        "from Visit v " +
        "group by YEAR(v.date)")
*/
    List<YearlyRevenue> listYearlyRevenue();

}
