package org.springframework.samples.petclinic.vets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Primary
@Service
public class VetsClient implements VetService {
    private final String url;

    public VetsClient(@Value("${vets.url}") String url) {
        this.url = url;
    }

    @Override
    public List<VetDto> allVets() {
        RestTemplate rest = new RestTemplate();
        VetDto[] vets = rest.getForObject(url, VetDto[].class);
        return Arrays.asList(vets);
    }
}
