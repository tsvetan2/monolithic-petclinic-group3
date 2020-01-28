package org.springframework.samples.petclinic.management;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ManagementServiceTests {

    @Autowired
    ManagementService service;

    @Test
    void shouldListYearlyRevenue() {
        List<YearlyRevenue> yearlyRevenues = service.listYearlyRevenue();

        assertThat(yearlyRevenues).hasSize(1);
        assertThat(yearlyRevenues.get(0).getTotal()).isEqualTo(1337L);
    }

    @Test
    @Transactional
    void shouldSaveRevenue() {
        service.saveRevenue(1, LocalDate.of(2020, 1, 2), 100);

        assertThat(service.listYearlyRevenue())
            .contains(new YearlyRevenue(2020, 100L));
    }
}
