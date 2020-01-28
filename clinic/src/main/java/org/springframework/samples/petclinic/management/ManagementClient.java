package org.springframework.samples.petclinic.management;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ManagementClient implements ManagementService {

    private final String baseUrl;
    private final RestTemplate restTemplate;

    public ManagementClient(@Value("${management-service.base-url}") String baseUrl) {
        this.baseUrl = baseUrl;
        restTemplate = new RestTemplate();
    }

    @Override
    public List<YearlyRevenue> listYearlyRevenue() {
        ResponseEntity<YearlyRevenue[]> revenues = restTemplate.getForEntity(baseUrl + "/revenue", YearlyRevenue[].class);
        return Arrays.asList(revenues.getBody());
    }
}
