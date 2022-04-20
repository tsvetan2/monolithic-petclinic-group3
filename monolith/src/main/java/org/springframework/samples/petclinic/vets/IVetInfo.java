package org.springframework.samples.petclinic.vets;

import java.util.List;

public interface IVetInfo {
    List<Specialty> getSpecialties();

    String getFirstName();

    String getLastName();
}
