/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.db.RevenueRepository;
import org.springframework.samples.petclinic.vets.Vet;
import org.springframework.samples.petclinic.vets.VetRepository;
import org.springframework.samples.petclinic.db.VisitRepository;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RepositoryIntegrationTests {

    @Autowired
    VetRepository vetsRepository;

    @Autowired
    VisitRepository visitsRepository;

    @Autowired
    RevenueRepository revenueRepository;

    @Test
    void testFindVets() {
        Collection<Vet> all = vetsRepository.findAll();
        assertThat(all).hasSize(6);
    }

    @Test
    void testFindVisits() {
        List<Visit> visits = this.visitsRepository.findByPetId(7);
        assertThat(visits).hasSize(2);
        assertThat(visits.get(0).getCost()).isEqualTo(100);
    }

    @Test
    void testGenerateRevenueReport() {
        List<YearlyRevenue> yearlyRevenues = this.revenueRepository.listYearlyRevenue();
        assertThat(yearlyRevenues).hasSize(1);
        assertThat(yearlyRevenues.get(0).getTotal()).isEqualTo(800L);
    }
}
