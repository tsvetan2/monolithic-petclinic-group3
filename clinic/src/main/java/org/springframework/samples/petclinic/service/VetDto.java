package org.springframework.samples.petclinic.service;

import java.util.List;

public class VetDto {

    public String firstName;
    public String lastName;
    public List<String> specialties;

    public VetDto(String firstName, String lastName, List<String> specialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialties = specialties;
    }

    public int getNrOfSpecialties() {
        return specialties.size();
    }
}
