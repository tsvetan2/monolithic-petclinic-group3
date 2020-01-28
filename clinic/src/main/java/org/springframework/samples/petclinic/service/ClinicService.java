package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.samples.petclinic.db.OwnerRepository;
import org.springframework.samples.petclinic.db.PetRepository;
import org.springframework.samples.petclinic.db.VetRepository;
import org.springframework.samples.petclinic.db.VisitRepository;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClinicService {

    @Autowired
    private OwnerRepository owners;

    @Autowired
    private PetRepository pets;

    @Autowired
    private VisitRepository visits;

    @Autowired
    private VetRepository vets;

    public Collection<Owner> ownerByLastName(String lastName) {
        return owners.findByLastName(lastName);
    }

    public Owner ownerById(int i) {
        return owners.findById(i);
    }

    public Pet petById(int id) {
        return pets.findById(id);
    }

    public List<PetType> petTypes() {
        return pets.findPetTypes();
    }

    public List<Visit> visitsByPetId(int petId) {
        return visits.findByPetId(petId);
    }

    public Collection<Vet> allVets() {
        return this.vets.findAll();
    }

    public void save(Owner owner) {
        owners.save(owner);
    }

    public void save(Pet pet) {
        pets.save(pet);
    }

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    public void save(Visit visit) {
        visits.save(visit);

        Map<String, Object> map = new HashMap<>();
        map.put("source_id", visit.getId());
        map.put("visit_date", visit.getDate().toString());
        map.put("cost", visit.getCost());
        messagingTemplate.send("visitCreated", new GenericMessage<>(map));
    }
}
