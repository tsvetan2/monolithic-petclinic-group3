package petclinic.vets;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VetWireMockDemoTest {
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
    void mockVetsOneResult() {
        wireMock.stubFor(get(urlEqualTo("/vets"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("[{\"firstName\":\"Sharon\",\"lastName\":\"Jenkins\",\"specialties\":[]}]")));

        IVetInfo[] result = new RestTemplate().getForObject("http://localhost:8089/vets", Vet[].class);

        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals("Sharon", result[0].getFirstName());
        assertEquals("Jenkins", result[0].getLastName());
    }
}
