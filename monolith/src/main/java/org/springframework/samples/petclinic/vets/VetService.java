package org.springframework.samples.petclinic.vets;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class VetService {
    final VetRepository vets;

    public VetService(VetRepository vets) {
        this.vets = vets;
    }

    public Collection<VetDto> allVets() {
        return this.vets.findAll()
            .stream()
            .map(this::mapToDto)
            .collect(Collectors.toList());
    }

    private VetDto mapToDto(Vet vet) {
        String[] specialties = vet.getSpecialties().stream()
            .map(Specialty::getName)
            .toArray(String[]::new);
        return new VetDto(vet.getFirstName(), vet.getLastName(), specialties);
    }
}