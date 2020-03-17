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
package org.springframework.samples.petclinic.vets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VetServiceTests {

    @Autowired
    MonolithVetService service;

    @Test
    void shouldFindVets() {
        Collection<VetDto> vets = service.allVets();

        assertThat(vets)
            .hasSize(6)
            .element(2)
            .hasFieldOrPropertyWithValue("lastName", "Douglas")
            .hasFieldOrPropertyWithValue("nrOfSpecialties", 2)
            .extracting("specialties").asList()
            .containsExactly("dentistry", "surgery");
    }
}
