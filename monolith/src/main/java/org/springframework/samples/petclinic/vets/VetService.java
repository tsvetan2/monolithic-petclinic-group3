package org.springframework.samples.petclinic.vets;

import java.util.Collection;

public interface VetService {
    Collection<VetDto> allVets();
}
