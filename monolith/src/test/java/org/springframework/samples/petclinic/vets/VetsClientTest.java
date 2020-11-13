package org.springframework.samples.petclinic.vets;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

public class VetsClientTest {

    private final WireMockServer wireMock = new WireMockServer(options().port(8089));

    @BeforeEach
    void startWireMock() {
        wireMock.start();
    }

    @AfterEach
    void stopWireMock() {
        wireMock.stop();
    }

    @Test
    void should_retrieve_vets_from_json_api() {
        wireMock.stubFor(get(urlEqualTo("/vets"))
            .willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody("[\n" +
                    "  {\n" +
                    "    \"firstName\": \"James\",\n" +
                    "    \"lastName\": \"Carter\",\n" +
                    "    \"specialties\": [],\n" +
                    "    \"nrOfSpecialties\": 0\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"firstName\": \"Helen\",\n" +
                    "    \"lastName\": \"Leary\",\n" +
                    "    \"specialties\": [\n" +
                    "      \"radiology\"\n" +
                    "    ],\n" +
                    "    \"nrOfSpecialties\": 1\n" +
                    "  }" +
                    "]")));
        VetsClient vetsClient = new VetsClient("http://localhost:8089/vets");

        List<VetDto> vets = vetsClient.allVets();

        assertThat(vets).hasSize(2)
            .containsExactly(
                new VetDto("James", "Carter"),
                new VetDto("Helen", "Leary", "radiology")
            );
    }
}
