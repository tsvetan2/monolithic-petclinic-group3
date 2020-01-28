package org.springframework.samples.petclinic.management;

import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManagementClientTests {

    HttpServer server;
    ManagementService client = new ManagementClient("http://127.0.0.1:7777/management");

    @BeforeEach
    void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(7777), 0);
        server.createContext("/management/revenue", exchange -> {
            String response = "[{\"year\":2020, \"total\":330}]";
            exchange.getResponseHeaders().add("content-type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.start();
    }

    @AfterEach
    void stopServer() {
        server.stop(0);
    }

    @Test
    void shouldRetrieveYearlyRevenueJson() {
        List<YearlyRevenue> yearlyRevenues = client.listYearlyRevenue();
        assertThat(yearlyRevenues)
            .containsExactly(new YearlyRevenue(2020, 330L));
    }

    // TODO add test for error case...
}
