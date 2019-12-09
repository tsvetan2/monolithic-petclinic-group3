package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.vets.Vet;
import org.springframework.samples.petclinic.vets.VetRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SameProcessVetGateway {
    @Autowired
    protected VetRepository vets;

    Collection<Vet> vetsGateway() {
        return this.vets.findAll();
    }
}