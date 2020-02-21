package org.springframework.samples.petclinic.vets;

import java.util.List;

import static java.util.Arrays.asList;

public class VetDto {

    public final String firstName;
    public final String lastName;
    public final List<String> specialties;
    public final Integer nrOfSpecialties;

    public VetDto(String firstName, String lastName, String... specialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialties = asList(specialties);
        this.nrOfSpecialties = specialties.length;
    }
}
