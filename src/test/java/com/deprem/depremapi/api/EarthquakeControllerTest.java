package com.deprem.depremapi.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EarthquakeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllEarthquakesForKandilli() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/earthquakes/kandili"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.*", hasSize(497)));
    }

    @Test
    void getAllEarthquakesForAfad() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/earthquakes/afad"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(100)));
    }

    @Test
    void filterByLocationForKandilli() throws Exception {

        String location = "malatya";

        mockMvc.perform(MockMvcRequestBuilders.get(String.format("/api/v1/earthquakes/kandili/locations/%s",location)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void filterByLocationForAfad() throws Exception {

        String location = "malatya";

        mockMvc.perform(MockMvcRequestBuilders.get(String.format("/api/v1/earthquakes/afad/locations/%s",location)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void filterBySizeMLForKandilli() throws Exception {

        String size = "3.2";

        mockMvc.perform(MockMvcRequestBuilders.get(String.format("/api/v1/earthquakes/kandili/sizes/%s",size)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void filterBySizeMLForAfad() throws Exception {

        String size = "3.2";

        mockMvc.perform(MockMvcRequestBuilders.get(String.format("/api/v1/earthquakes/afad/sizes/%s",size)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void filterByLocationAndSizeForKandilli() throws Exception {

        String size = "3.2";
        String location = "malatya";

        mockMvc.perform(
                MockMvcRequestBuilders.get(String.format("/api/v1/earthquakes/kandili/search"))
                        .param("location",location)
                        .param("size",size)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

    }

    @Test
    void filterByLocationAndSizeForAfad() throws Exception {

        String size = "3.2";
        String location = "malatya";

        mockMvc.perform(
                        MockMvcRequestBuilders.get(String.format("/api/v1/earthquakes/afad/search"))
                                .param("location",location)
                                .param("size",size)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void filterBySizeBetweenTwoMLForKandili() throws Exception {

        String minml = "3.2";
        String maxml = "4.0";

        mockMvc.perform(
                        MockMvcRequestBuilders.get(String.format("/api/v1/earthquakes/kandili/sizes"))
                                .param("minml",minml)
                                .param("maxml",maxml)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

    }

    @Test
    void filterBySizeBetweenTwoMLForAfad() throws Exception {

        String minml = "3.2";
        String maxml = "4.0";

        mockMvc.perform(
                        MockMvcRequestBuilders.get(String.format("/api/v1/earthquakes/afad/sizes"))
                                .param("minml",minml)
                                .param("maxml",maxml)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}