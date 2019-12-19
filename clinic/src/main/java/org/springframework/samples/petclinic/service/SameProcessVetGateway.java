package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.vets.Vet;
import org.springframework.samples.petclinic.vets.VetRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SameProcessVetGateway {
    @Autowired
    protected VetRepository vets;

    Collection<VetDto> vets2Gateway() {
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