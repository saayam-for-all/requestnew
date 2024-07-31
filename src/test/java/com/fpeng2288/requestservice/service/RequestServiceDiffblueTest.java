package com.fpeng2288.requestservice.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fpeng2288.requestservice.model.Request;
import com.fpeng2288.requestservice.repository.RequestRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RequestService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RequestServiceDiffblueTest {
    @MockBean
    private RequestRepository requestRepository;

    @Autowired
    private RequestService requestService;

    /**
     * Method under test: {@link RequestService#getAllRequests()}
     */
    @Test
    void testGetAllRequests() {
        // Arrange
        ArrayList<Request> requestList = new ArrayList<>();
        when(requestRepository.findAll()).thenReturn(requestList);

        // Act
        List<Request> actualAllRequests = requestService.getAllRequests();

        // Assert
        verify(requestRepository).findAll();
        assertTrue(actualAllRequests.isEmpty());
        assertSame(requestList, actualAllRequests);
    }

    /**
     * Method under test: {@link RequestService#getRequestById(Long)}
     */
    @Test
    void testGetRequestById() {
        // Arrange
        Request request = new Request();
        request.setId(1L);
        request.setRequestCategory("Request Category");
        request.setRequestDescription("Request Description");
        request.setRequestFor("Request For");
        request.setRequestId("42");
        request.setRequestLocation("Request Location");
        request.setRequestPriority("Request Priority");
        request.setRequestStatus("Request Status");
        request.setRequestTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        request.setRequestType("Request Type");
        Optional<Request> ofResult = Optional.of(request);
        when(requestRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Request actualRequestById = requestService.getRequestById(1L);

        // Assert
        verify(requestRepository).findById(eq(1L));
        assertSame(request, actualRequestById);
    }

    /**
     * Method under test: {@link RequestService#saveRequest(Request)}
     */
    @Test
    void testSaveRequest() {
        // Arrange
        Request request = new Request();
        request.setId(1L);
        request.setRequestCategory("Request Category");
        request.setRequestDescription("Request Description");
        request.setRequestFor("Request For");
        request.setRequestId("42");
        request.setRequestLocation("Request Location");
        request.setRequestPriority("Request Priority");
        request.setRequestStatus("Request Status");
        request.setRequestTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        request.setRequestType("Request Type");
        when(requestRepository.save(Mockito.<Request>any())).thenReturn(request);

        Request request2 = new Request();
        request2.setId(1L);
        request2.setRequestCategory("Request Category");
        request2.setRequestDescription("Request Description");
        request2.setRequestFor("Request For");
        request2.setRequestId("42");
        request2.setRequestLocation("Request Location");
        request2.setRequestPriority("Request Priority");
        request2.setRequestStatus("Request Status");
        request2.setRequestTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        request2.setRequestType("Request Type");

        // Act
        Request actualSaveRequestResult = requestService.saveRequest(request2);

        // Assert
        verify(requestRepository).save(isA(Request.class));
        assertSame(request, actualSaveRequestResult);
    }

    /**
     * Method under test: {@link RequestService#deleteRequest(Long)}
     */
    @Test
    void testDeleteRequest() {
        // Arrange
        doNothing().when(requestRepository).deleteById(Mockito.<Long>any());

        // Act
        requestService.deleteRequest(1L);

        // Assert that nothing has changed
        verify(requestRepository).deleteById(eq(1L));
        assertTrue(requestService.getAllRequests().isEmpty());
    }
}
