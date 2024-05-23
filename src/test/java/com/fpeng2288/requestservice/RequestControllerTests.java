package com.fpeng2288.requestservice;

import com.fpeng2288.requestservice.model.Request;
import com.fpeng2288.requestservice.repository.RequestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class RequestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RequestRepository requestRepository;

    @Test
    public void testCreateRequest() throws Exception {
        String newRequestJson = "{\"requestId\": \"123\", \"requestDescription\": \"Test request\", \"requestTime\": \"2023-05-16T12:00:00\", \"requestStatus\": \"Pending\", \"requestPriority\": \"High\", \"requestLocation\": \"Location A\", \"requestCategory\": \"Category A\", \"requestType\": \"Type A\", \"requestFor\": \"User A\"}";

        mockMvc.perform(post("/requests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newRequestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.requestId").value("123"))
                .andExpect(jsonPath("$.requestDescription").value("Test request"));
    }

    @Test
    public void testUpdateRequest() throws Exception {
        Request request = new Request("123", "Test request", LocalDateTime.parse("2023-05-16T12:00:00"), "Pending", "High", "Location A", "TECHNICAL_SUPPORT", "DIGITAL", "User A");
        requestRepository.save(request);

        String updatedRequestJson = "{\"requestId\": \"123\", \"requestDescription\": \"Updated request\", \"requestTime\": \"2023-05-16T12:00:00\", \"requestStatus\": \"Completed\", \"requestPriority\": \"High\", \"requestLocation\": \"Location B\", \"requestCategory\": \"Category B\", \"requestType\": \"Type B\", \"requestFor\": \"User B\"}";

        mockMvc.perform(put("/requests/" + request.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedRequestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.requestDescription").value("Updated request"))
                .andExpect(jsonPath("$.requestStatus").value("Completed"));
    }

    @Test
    public void testDeleteRequest() throws Exception {
        Request request = new Request("123", "Test request", LocalDateTime.parse("2023-05-16T12:00:00"), "Pending", "High", "Location A", "TECHNICAL_SUPPORT", "DIGITAL", "User A");
        requestRepository.save(request);

        mockMvc.perform(delete("/requests/" + request.getId()))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testGetAllRequests() throws Exception {
        mockMvc.perform(get("/requests"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetRequestById() throws Exception {
        Request request = new Request("123", "Test request", LocalDateTime.parse("2023-05-16T12:00:00"), "Pending", "High", "Location A", "TECHNICAL_SUPPORT", "DIGITAL", "User A");
        requestRepository.save(request);

        mockMvc.perform(get("/requests/" + request.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.requestId").value("123"));
    }
}
