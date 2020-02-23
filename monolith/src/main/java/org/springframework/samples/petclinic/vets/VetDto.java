package org.springframework.samples.petclinic.vets;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class VetDto {

    public final String firstName;
    public final String lastName;
    public final List<String> specialties;
    public final Integer nrOfSpecialties;

    @JsonCreator
    public VetDto(
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("specialties") String... specialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialties = asList(specialties);
        this.nrOfSpecialties = specialties.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VetDto vetDto = (VetDto) o;
        return Objects.equals(firstName, vetDto.firstName) &&
            Objects.equals(lastName, vetDto.lastName) &&
            Objects.equals(specialties, vetDto.specialties) &&
            Objects.equals(nrOfSpecialties, vetDto.nrOfSpecialties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, specialties, nrOfSpecialties);
    }

    @Override
    public String toString() {
        return "VetDto{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", specialties=" + specialties +
            ", nrOfSpecialties=" + nrOfSpecialties +
            '}';
    }
}
