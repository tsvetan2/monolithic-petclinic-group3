package org.springframework.samples.petclinic.vets;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class VetsClient {
    private final String url;

    public VetsClient(String url) {
        this.url = url;
    }

    public List<VetDto> allVets() {
        RestTemplate rest = new RestTemplate();
        VetDto[] vets = rest.getForObject(url, VetDto[].class);
        return Arrays.asList(vets);
    }
}
