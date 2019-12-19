package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Service
public class RestVetGateway implements VetGateway {

    @Autowired
    private RestTemplate template;

    @Override
    public Collection<VetDto> vetList() {
        ResponseEntity<VetDto[]> response = template.getForEntity("http://localhost:8081/vets", VetDto[].class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return Arrays.asList(response.getBody());
        } else {
            // TODO log warn
            return Collections.emptyList();
        }
    }
}
