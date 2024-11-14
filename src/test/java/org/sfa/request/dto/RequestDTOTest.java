package org.sfa.request.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RequestDTO.class})
@ExtendWith(SpringExtension.class)
class RequestDTOTest {
    @Autowired
    private RequestDTO requestDTO;

    /**
     * Method under test: {@link RequestDTO#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse(requestDTO.canEqual("Other"));
        assertTrue(requestDTO.canEqual(requestDTO));
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals() {
        // Arrange, Act and Assert
        assertNotEquals(new RequestDTO(), null);
        assertNotEquals(new RequestDTO(), "Different type to RequestDTO");
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals2() {
        // Arrange
        ZonedDateTime submittedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        ZonedDateTime servicedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        ZonedDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        RequestStatusDTO requestStatus = new RequestStatusDTO();
        RequestPriorityDTO requestPriority = new RequestPriorityDTO();
        RequestTypeDTO requestType = new RequestTypeDTO();
        RequestCategoryDTO requestCategory = new RequestCategoryDTO();
        RequestDTO requestDTO = new RequestDTO("42", "Request Description", "Audio Request Description", "Oxford", "21654",
                submittedAt, 1, servicedAt, lastUpdatedAt, requestStatus, requestPriority, requestType, requestCategory,
                new RequestForDTO());

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals3() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        ZonedDateTime submittedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        ZonedDateTime servicedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        ZonedDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        RequestStatusDTO requestStatus = new RequestStatusDTO();
        RequestPriorityDTO requestPriority = new RequestPriorityDTO();
        RequestTypeDTO requestType = new RequestTypeDTO();
        RequestCategoryDTO requestCategory = new RequestCategoryDTO();

        // Act and Assert
        assertNotEquals(requestDTO,
                new RequestDTO("42", "Request Description", "Audio Request Description", "Oxford", "21654", submittedAt, 1,
                        servicedAt, lastUpdatedAt, requestStatus, requestPriority, requestType, requestCategory,
                        new RequestForDTO()));
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals4() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setRequesterId("42");

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals5() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setRequestDescription("Request Description");

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals6() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setAudioRequestDescription("Audio Request Description");

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals7() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setCity("Oxford");

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals8() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setZipCode("21654");

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals9() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals10() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setServicedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals11() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals12() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setRequestStatus(new RequestStatusDTO());

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals13() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setRequestPriority(new RequestPriorityDTO());

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals14() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setRequestType(new RequestTypeDTO());

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals15() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setRequestCategory(new RequestCategoryDTO());

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals16() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setRequestFor(new RequestForDTO());

        // Act and Assert
        assertNotEquals(requestDTO, new RequestDTO());
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals17() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setRequesterId("42");

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals18() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setRequestDescription("Request Description");

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals19() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setAudioRequestDescription("Audio Request Description");

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals20() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setCity("Oxford");

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals21() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setZipCode("21654");

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals22() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals23() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setServicedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals24() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals25() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setRequestStatus(new RequestStatusDTO());

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals26() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setRequestPriority(new RequestPriorityDTO());

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals27() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setRequestType(new RequestTypeDTO());

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals28() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setRequestCategory(new RequestCategoryDTO());

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Method under test: {@link RequestDTO#equals(Object)}
     */
    @Test
    void testEquals29() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        RequestDTO requestDTO2 = new RequestDTO();
        requestDTO2.setRequestFor(new RequestForDTO());

        // Act and Assert
        assertNotEquals(requestDTO, requestDTO2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RequestDTO#equals(Object)}
     *   <li>{@link RequestDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();

        // Act and Assert
        assertEquals(requestDTO, requestDTO);
        int expectedHashCodeResult = requestDTO.hashCode();
        assertEquals(expectedHashCodeResult, requestDTO.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RequestDTO#equals(Object)}
     *   <li>{@link RequestDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode2() {
        // Arrange
        RequestDTO requestDTO = new RequestDTO();
        RequestDTO requestDTO2 = new RequestDTO();

        // Act and Assert
        assertEquals(requestDTO, requestDTO2);
        int expectedHashCodeResult = requestDTO.hashCode();
        assertEquals(expectedHashCodeResult, requestDTO2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RequestDTO#equals(Object)}
     *   <li>{@link RequestDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode3() {
        // Arrange
        ZonedDateTime submittedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        ZonedDateTime servicedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        ZonedDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        RequestStatusDTO requestStatus = new RequestStatusDTO();
        RequestPriorityDTO requestPriority = new RequestPriorityDTO();
        RequestTypeDTO requestType = new RequestTypeDTO();
        RequestCategoryDTO requestCategory = new RequestCategoryDTO();
        RequestDTO requestDTO = new RequestDTO("42", "Request Description", "Audio Request Description", "Oxford", "21654",
                submittedAt, 1, servicedAt, lastUpdatedAt, requestStatus, requestPriority, requestType, requestCategory,
                new RequestForDTO());
        ZonedDateTime submittedAt2 = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        ZonedDateTime servicedAt2 = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        ZonedDateTime lastUpdatedAt2 = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        RequestStatusDTO requestStatus2 = new RequestStatusDTO();
        RequestPriorityDTO requestPriority2 = new RequestPriorityDTO();
        RequestTypeDTO requestType2 = new RequestTypeDTO();
        RequestCategoryDTO requestCategory2 = new RequestCategoryDTO();
        RequestDTO requestDTO2 = new RequestDTO("42", "Request Description", "Audio Request Description", "Oxford", "21654",
                submittedAt2, 1, servicedAt2, lastUpdatedAt2, requestStatus2, requestPriority2, requestType2, requestCategory2,
                new RequestForDTO());

        // Act and Assert
        assertEquals(requestDTO, requestDTO2);
        int expectedHashCodeResult = requestDTO.hashCode();
        assertEquals(expectedHashCodeResult, requestDTO2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RequestDTO#RequestDTO()}
     *   <li>{@link RequestDTO#setAudioRequestDescription(String)}
     *   <li>{@link RequestDTO#setCity(String)}
     *   <li>{@link RequestDTO#setLastUpdatedAt(ZonedDateTime)}
     *   <li>{@link RequestDTO#setLeadVolunteerUserId(Integer)}
     *   <li>{@link RequestDTO#setRequestCategory(RequestCategoryDTO)}
     *   <li>{@link RequestDTO#setRequestDescription(String)}
     *   <li>{@link RequestDTO#setRequestFor(RequestForDTO)}
     *   <li>{@link RequestDTO#setRequestPriority(RequestPriorityDTO)}
     *   <li>{@link RequestDTO#setRequestStatus(RequestStatusDTO)}
     *   <li>{@link RequestDTO#setRequestType(RequestTypeDTO)}
     *   <li>{@link RequestDTO#setRequesterId(String)}
     *   <li>{@link RequestDTO#setServicedAt(ZonedDateTime)}
     *   <li>{@link RequestDTO#setSubmittedAt(ZonedDateTime)}
     *   <li>{@link RequestDTO#setZipCode(String)}
     *   <li>{@link RequestDTO#toString()}
     *   <li>{@link RequestDTO#getAudioRequestDescription()}
     *   <li>{@link RequestDTO#getCity()}
     *   <li>{@link RequestDTO#getLastUpdatedAt()}
     *   <li>{@link RequestDTO#getLeadVolunteerUserId()}
     *   <li>{@link RequestDTO#getRequestCategory()}
     *   <li>{@link RequestDTO#getRequestDescription()}
     *   <li>{@link RequestDTO#getRequestFor()}
     *   <li>{@link RequestDTO#getRequestPriority()}
     *   <li>{@link RequestDTO#getRequestStatus()}
     *   <li>{@link RequestDTO#getRequestType()}
     *   <li>{@link RequestDTO#getRequesterId()}
     *   <li>{@link RequestDTO#getServicedAt()}
     *   <li>{@link RequestDTO#getSubmittedAt()}
     *   <li>{@link RequestDTO#getZipCode()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        RequestDTO actualRequestDTO = new RequestDTO();
        actualRequestDTO.setAudioRequestDescription("Audio Request Description");
        actualRequestDTO.setCity("Oxford");
        ZonedDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        actualRequestDTO.setLastUpdatedAt(lastUpdatedAt);
        actualRequestDTO.setLeadVolunteerUserId(1);
        RequestCategoryDTO requestCategory = new RequestCategoryDTO();
        actualRequestDTO.setRequestCategory(requestCategory);
        actualRequestDTO.setRequestDescription("Request Description");
        RequestForDTO requestFor = new RequestForDTO();
        actualRequestDTO.setRequestFor(requestFor);
        RequestPriorityDTO requestPriority = new RequestPriorityDTO();
        actualRequestDTO.setRequestPriority(requestPriority);
        RequestStatusDTO requestStatus = new RequestStatusDTO();
        actualRequestDTO.setRequestStatus(requestStatus);
        RequestTypeDTO requestType = new RequestTypeDTO();
        actualRequestDTO.setRequestType(requestType);
        actualRequestDTO.setRequesterId("42");
        ZonedDateTime servicedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        actualRequestDTO.setServicedAt(servicedAt);
        ZonedDateTime submittedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        actualRequestDTO.setSubmittedAt(submittedAt);
        actualRequestDTO.setZipCode("21654");
        String actualToStringResult = actualRequestDTO.toString();
        String actualAudioRequestDescription = actualRequestDTO.getAudioRequestDescription();
        String actualCity = actualRequestDTO.getCity();
        ZonedDateTime actualLastUpdatedAt = actualRequestDTO.getLastUpdatedAt();
        Integer actualLeadVolunteerUserId = actualRequestDTO.getLeadVolunteerUserId();
        RequestCategoryDTO actualRequestCategory = actualRequestDTO.getRequestCategory();
        String actualRequestDescription = actualRequestDTO.getRequestDescription();
        RequestForDTO actualRequestFor = actualRequestDTO.getRequestFor();
        RequestPriorityDTO actualRequestPriority = actualRequestDTO.getRequestPriority();
        RequestStatusDTO actualRequestStatus = actualRequestDTO.getRequestStatus();
        RequestTypeDTO actualRequestType = actualRequestDTO.getRequestType();
        String actualRequesterId = actualRequestDTO.getRequesterId();
        ZonedDateTime actualServicedAt = actualRequestDTO.getServicedAt();
        ZonedDateTime actualSubmittedAt = actualRequestDTO.getSubmittedAt();

        // Assert that nothing has changed
        assertEquals("21654", actualRequestDTO.getZipCode());
        assertEquals("42", actualRequesterId);
        assertEquals("Audio Request Description", actualAudioRequestDescription);
        assertEquals("Oxford", actualCity);
        assertEquals("Request Description", actualRequestDescription);
        assertEquals(
                "RequestDTO(requesterId=42, requestDescription=Request Description, audioRequestDescription=Audio Request"
                        + " Description, city=Oxford, zipCode=21654, submittedAt=1970-01-01T00:00Z, leadVolunteerUserId=1,"
                        + " servicedAt=1970-01-01T00:00Z, lastUpdatedAt=1970-01-01T00:00Z, requestStatus=RequestStatusDTO"
                        + "(requestStatusId=null), requestPriority=RequestPriorityDTO(requestPriorityId=null), requestType"
                        + "=RequestTypeDTO(requestTypeId=null), requestCategory=RequestCategoryDTO(requestCategoryId=null),"
                        + " requestFor=RequestForDTO(requestForId=null))",
                actualToStringResult);
        assertEquals(1, actualLeadVolunteerUserId.intValue());
        assertSame(requestCategory, actualRequestCategory);
        assertSame(requestFor, actualRequestFor);
        assertSame(requestPriority, actualRequestPriority);
        assertSame(requestStatus, actualRequestStatus);
        assertSame(requestType, actualRequestType);
        assertSame(lastUpdatedAt, actualLastUpdatedAt);
        assertSame(servicedAt, actualServicedAt);
        assertSame(submittedAt, actualSubmittedAt);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link RequestDTO#RequestDTO(String, String, String, String, String, ZonedDateTime, Integer, ZonedDateTime, ZonedDateTime, RequestStatusDTO, RequestPriorityDTO, RequestTypeDTO, RequestCategoryDTO, RequestForDTO)}
     *   <li>{@link RequestDTO#setAudioRequestDescription(String)}
     *   <li>{@link RequestDTO#setCity(String)}
     *   <li>{@link RequestDTO#setLastUpdatedAt(ZonedDateTime)}
     *   <li>{@link RequestDTO#setLeadVolunteerUserId(Integer)}
     *   <li>{@link RequestDTO#setRequestCategory(RequestCategoryDTO)}
     *   <li>{@link RequestDTO#setRequestDescription(String)}
     *   <li>{@link RequestDTO#setRequestFor(RequestForDTO)}
     *   <li>{@link RequestDTO#setRequestPriority(RequestPriorityDTO)}
     *   <li>{@link RequestDTO#setRequestStatus(RequestStatusDTO)}
     *   <li>{@link RequestDTO#setRequestType(RequestTypeDTO)}
     *   <li>{@link RequestDTO#setRequesterId(String)}
     *   <li>{@link RequestDTO#setServicedAt(ZonedDateTime)}
     *   <li>{@link RequestDTO#setSubmittedAt(ZonedDateTime)}
     *   <li>{@link RequestDTO#setZipCode(String)}
     *   <li>{@link RequestDTO#toString()}
     *   <li>{@link RequestDTO#getAudioRequestDescription()}
     *   <li>{@link RequestDTO#getCity()}
     *   <li>{@link RequestDTO#getLastUpdatedAt()}
     *   <li>{@link RequestDTO#getLeadVolunteerUserId()}
     *   <li>{@link RequestDTO#getRequestCategory()}
     *   <li>{@link RequestDTO#getRequestDescription()}
     *   <li>{@link RequestDTO#getRequestFor()}
     *   <li>{@link RequestDTO#getRequestPriority()}
     *   <li>{@link RequestDTO#getRequestStatus()}
     *   <li>{@link RequestDTO#getRequestType()}
     *   <li>{@link RequestDTO#getRequesterId()}
     *   <li>{@link RequestDTO#getServicedAt()}
     *   <li>{@link RequestDTO#getSubmittedAt()}
     *   <li>{@link RequestDTO#getZipCode()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange
        ZonedDateTime submittedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        ZonedDateTime servicedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        ZonedDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        RequestStatusDTO requestStatus = new RequestStatusDTO();
        RequestPriorityDTO requestPriority = new RequestPriorityDTO();
        RequestTypeDTO requestType = new RequestTypeDTO();
        RequestCategoryDTO requestCategory = new RequestCategoryDTO();
        RequestForDTO requestFor = new RequestForDTO();

        // Act
        RequestDTO actualRequestDTO = new RequestDTO("42", "Request Description", "Audio Request Description", "Oxford",
                "21654", submittedAt, 1, servicedAt, lastUpdatedAt, requestStatus, requestPriority, requestType,
                requestCategory, requestFor);
        actualRequestDTO.setAudioRequestDescription("Audio Request Description");
        actualRequestDTO.setCity("Oxford");
        ZonedDateTime lastUpdatedAt2 = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        actualRequestDTO.setLastUpdatedAt(lastUpdatedAt2);
        actualRequestDTO.setLeadVolunteerUserId(1);
        RequestCategoryDTO requestCategory2 = new RequestCategoryDTO();
        actualRequestDTO.setRequestCategory(requestCategory2);
        actualRequestDTO.setRequestDescription("Request Description");
        RequestForDTO requestFor2 = new RequestForDTO();
        actualRequestDTO.setRequestFor(requestFor2);
        RequestPriorityDTO requestPriority2 = new RequestPriorityDTO();
        actualRequestDTO.setRequestPriority(requestPriority2);
        RequestStatusDTO requestStatus2 = new RequestStatusDTO();
        actualRequestDTO.setRequestStatus(requestStatus2);
        RequestTypeDTO requestType2 = new RequestTypeDTO();
        actualRequestDTO.setRequestType(requestType2);
        actualRequestDTO.setRequesterId("42");
        ZonedDateTime servicedAt2 = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        actualRequestDTO.setServicedAt(servicedAt2);
        ZonedDateTime submittedAt2 = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
        actualRequestDTO.setSubmittedAt(submittedAt2);
        actualRequestDTO.setZipCode("21654");
        String actualToStringResult = actualRequestDTO.toString();
        String actualAudioRequestDescription = actualRequestDTO.getAudioRequestDescription();
        String actualCity = actualRequestDTO.getCity();
        ZonedDateTime actualLastUpdatedAt = actualRequestDTO.getLastUpdatedAt();
        Integer actualLeadVolunteerUserId = actualRequestDTO.getLeadVolunteerUserId();
        RequestCategoryDTO actualRequestCategory = actualRequestDTO.getRequestCategory();
        String actualRequestDescription = actualRequestDTO.getRequestDescription();
        RequestForDTO actualRequestFor = actualRequestDTO.getRequestFor();
        RequestPriorityDTO actualRequestPriority = actualRequestDTO.getRequestPriority();
        RequestStatusDTO actualRequestStatus = actualRequestDTO.getRequestStatus();
        RequestTypeDTO actualRequestType = actualRequestDTO.getRequestType();
        String actualRequesterId = actualRequestDTO.getRequesterId();
        ZonedDateTime actualServicedAt = actualRequestDTO.getServicedAt();
        ZonedDateTime actualSubmittedAt = actualRequestDTO.getSubmittedAt();

        // Assert that nothing has changed
        assertEquals("21654", actualRequestDTO.getZipCode());
        assertEquals("42", actualRequesterId);
        assertEquals("Audio Request Description", actualAudioRequestDescription);
        assertEquals("Oxford", actualCity);
        assertEquals("Request Description", actualRequestDescription);
        assertEquals(
                "RequestDTO(requesterId=42, requestDescription=Request Description, audioRequestDescription=Audio Request"
                        + " Description, city=Oxford, zipCode=21654, submittedAt=1970-01-01T00:00Z, leadVolunteerUserId=1,"
                        + " servicedAt=1970-01-01T00:00Z, lastUpdatedAt=1970-01-01T00:00Z, requestStatus=RequestStatusDTO"
                        + "(requestStatusId=null), requestPriority=RequestPriorityDTO(requestPriorityId=null), requestType"
                        + "=RequestTypeDTO(requestTypeId=null), requestCategory=RequestCategoryDTO(requestCategoryId=null),"
                        + " requestFor=RequestForDTO(requestForId=null))",
                actualToStringResult);
        assertEquals(1, actualLeadVolunteerUserId.intValue());
        assertEquals(requestCategory, actualRequestCategory);
        assertEquals(requestFor, actualRequestFor);
        assertEquals(requestPriority, actualRequestPriority);
        assertEquals(requestStatus, actualRequestStatus);
        assertEquals(requestType, actualRequestType);
        assertSame(requestCategory2, actualRequestCategory);
        assertSame(requestFor2, actualRequestFor);
        assertSame(requestPriority2, actualRequestPriority);
        assertSame(requestStatus2, actualRequestStatus);
        assertSame(requestType2, actualRequestType);
        assertSame(lastUpdatedAt2, actualLastUpdatedAt);
        assertSame(servicedAt2, actualServicedAt);
        assertSame(submittedAt2, actualSubmittedAt);
    }
}
