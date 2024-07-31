package com.fpeng2288.requestservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class RequestDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Request#Request()}
     *   <li>{@link Request#setId(Long)}
     *   <li>{@link Request#setRequestCategory(String)}
     *   <li>{@link Request#setRequestDescription(String)}
     *   <li>{@link Request#setRequestFor(String)}
     *   <li>{@link Request#setRequestId(String)}
     *   <li>{@link Request#setRequestLocation(String)}
     *   <li>{@link Request#setRequestPriority(String)}
     *   <li>{@link Request#setRequestStatus(String)}
     *   <li>{@link Request#setRequestTime(LocalDateTime)}
     *   <li>{@link Request#setRequestType(String)}
     *   <li>{@link Request#getId()}
     *   <li>{@link Request#getRequestCategory()}
     *   <li>{@link Request#getRequestDescription()}
     *   <li>{@link Request#getRequestFor()}
     *   <li>{@link Request#getRequestId()}
     *   <li>{@link Request#getRequestLocation()}
     *   <li>{@link Request#getRequestPriority()}
     *   <li>{@link Request#getRequestStatus()}
     *   <li>{@link Request#getRequestTime()}
     *   <li>{@link Request#getRequestType()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Request actualRequest = new Request();
        actualRequest.setId(1L);
        actualRequest.setRequestCategory("Request Category");
        actualRequest.setRequestDescription("Request Description");
        actualRequest.setRequestFor("Request For");
        actualRequest.setRequestId("42");
        actualRequest.setRequestLocation("Request Location");
        actualRequest.setRequestPriority("Request Priority");
        actualRequest.setRequestStatus("Request Status");
        LocalDateTime requestTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualRequest.setRequestTime(requestTime);
        actualRequest.setRequestType("Request Type");
        Long actualId = actualRequest.getId();
        String actualRequestCategory = actualRequest.getRequestCategory();
        String actualRequestDescription = actualRequest.getRequestDescription();
        String actualRequestFor = actualRequest.getRequestFor();
        String actualRequestId = actualRequest.getRequestId();
        String actualRequestLocation = actualRequest.getRequestLocation();
        String actualRequestPriority = actualRequest.getRequestPriority();
        String actualRequestStatus = actualRequest.getRequestStatus();
        LocalDateTime actualRequestTime = actualRequest.getRequestTime();

        // Assert that nothing has changed
        assertEquals("42", actualRequestId);
        assertEquals("Request Category", actualRequestCategory);
        assertEquals("Request Description", actualRequestDescription);
        assertEquals("Request For", actualRequestFor);
        assertEquals("Request Location", actualRequestLocation);
        assertEquals("Request Priority", actualRequestPriority);
        assertEquals("Request Status", actualRequestStatus);
        assertEquals("Request Type", actualRequest.getRequestType());
        assertEquals(1L, actualId.longValue());
        assertSame(requestTime, actualRequestTime);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link Request#Request(String, String, LocalDateTime, String, String, String, String, String, String)}
     *   <li>{@link Request#setId(Long)}
     *   <li>{@link Request#setRequestCategory(String)}
     *   <li>{@link Request#setRequestDescription(String)}
     *   <li>{@link Request#setRequestFor(String)}
     *   <li>{@link Request#setRequestId(String)}
     *   <li>{@link Request#setRequestLocation(String)}
     *   <li>{@link Request#setRequestPriority(String)}
     *   <li>{@link Request#setRequestStatus(String)}
     *   <li>{@link Request#setRequestTime(LocalDateTime)}
     *   <li>{@link Request#setRequestType(String)}
     *   <li>{@link Request#getId()}
     *   <li>{@link Request#getRequestCategory()}
     *   <li>{@link Request#getRequestDescription()}
     *   <li>{@link Request#getRequestFor()}
     *   <li>{@link Request#getRequestId()}
     *   <li>{@link Request#getRequestLocation()}
     *   <li>{@link Request#getRequestPriority()}
     *   <li>{@link Request#getRequestStatus()}
     *   <li>{@link Request#getRequestTime()}
     *   <li>{@link Request#getRequestType()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        Request actualRequest = new Request("42", "Request Description", LocalDate.of(1970, 1, 1).atStartOfDay(),
                "Request Status", "Request Priority", "Request Location", "Request Category", "Request Type", "Request For");
        actualRequest.setId(1L);
        actualRequest.setRequestCategory("Request Category");
        actualRequest.setRequestDescription("Request Description");
        actualRequest.setRequestFor("Request For");
        actualRequest.setRequestId("42");
        actualRequest.setRequestLocation("Request Location");
        actualRequest.setRequestPriority("Request Priority");
        actualRequest.setRequestStatus("Request Status");
        LocalDateTime requestTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualRequest.setRequestTime(requestTime);
        actualRequest.setRequestType("Request Type");
        Long actualId = actualRequest.getId();
        String actualRequestCategory = actualRequest.getRequestCategory();
        String actualRequestDescription = actualRequest.getRequestDescription();
        String actualRequestFor = actualRequest.getRequestFor();
        String actualRequestId = actualRequest.getRequestId();
        String actualRequestLocation = actualRequest.getRequestLocation();
        String actualRequestPriority = actualRequest.getRequestPriority();
        String actualRequestStatus = actualRequest.getRequestStatus();
        LocalDateTime actualRequestTime = actualRequest.getRequestTime();

        // Assert that nothing has changed
        assertEquals("42", actualRequestId);
        assertEquals("Request Category", actualRequestCategory);
        assertEquals("Request Description", actualRequestDescription);
        assertEquals("Request For", actualRequestFor);
        assertEquals("Request Location", actualRequestLocation);
        assertEquals("Request Priority", actualRequestPriority);
        assertEquals("Request Status", actualRequestStatus);
        assertEquals("Request Type", actualRequest.getRequestType());
        assertEquals(1L, actualId.longValue());
        assertSame(requestTime, actualRequestTime);
    }
}
