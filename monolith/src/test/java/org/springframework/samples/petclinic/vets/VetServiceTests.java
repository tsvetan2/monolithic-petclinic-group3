package org.springframework.samples.petclinic.vets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VetServiceTests {
    @Autowired
    VetService vetService;

    @Test
    void shouldFindVets() {
        Collection<IVetInfo> vets = vetService.allVets();

        assertThat(vets)
                .filteredOn(vet -> vet.getLastName().equals("Douglas"))
                .hasSize(1)
                .first()
                .hasFieldOrPropertyWithValue("lastName", "Douglas")
                .hasFieldOrPropertyWithValue("firstName", "Linda")
                .hasFieldOrPropertyWithValue("nrOfSpecialties", 2)
                .extracting(IVetInfo::getSpecialties).asList()
                .extracting("name")
                .containsExactly("dentistry", "surgery");
    }
}
