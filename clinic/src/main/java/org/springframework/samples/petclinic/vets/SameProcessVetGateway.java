package org.springframework.samples.petclinic.vets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.service.VetDto;
import org.springframework.samples.petclinic.service.VetGateway;
import org.springframework.samples.petclinic.vets.Vet;
import org.springframework.samples.petclinic.vets.VetRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SameProcessVetGateway implements VetGateway {
    @Autowired
    private VetRepository vets;

    @Override
    public Collection<VetDto> vetList() {
        return this.vets.findAll()
            .stream()
            .map(this::createVetDto)
            .collect(Collectors.toList());
    }

    private VetDto createVetDto(Vet v) {
        return new VetDto(
            v.getFirstName(),
            v.getLastName(),
            v.getSpecialties().stream().map(s -> s.getName()).collect(Collectors.toList()
            ));
    }

}