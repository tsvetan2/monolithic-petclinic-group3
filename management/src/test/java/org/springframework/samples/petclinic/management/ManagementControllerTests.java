package org.springframework.samples.petclinic.management;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {ManagementController.class})
class ManagementControllerTests {

    static final List<YearlyRevenue> EXPECTED_REVENUES = asList(
        new YearlyRevenue(2020, 333L)
    );

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ManagementService service;

    @BeforeEach
    void setup() {
        given(this.service.listYearlyRevenue()).willReturn(EXPECTED_REVENUES);
    }

    @Test
    void testShowRevenueJson() throws Exception {
        mockMvc.perform(get("/management/revenue")) //
            .andExpect(status().isOk()) //
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].year").value(2020))
            .andExpect(jsonPath("$[0].total").value(333));
    }

}
