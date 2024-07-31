package com.fpeng2288.requestservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpeng2288.requestservice.model.Request;
import com.fpeng2288.requestservice.service.RequestService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {RequestController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RequestControllerDiffblueTest {
  @Autowired
  private RequestController requestController;

  @MockBean
  private RequestService requestService;

  /**
   * Method under test: {@link RequestController#getAllRequests()}
   */
  @Test
  void testGetAllRequests() throws Exception {
    // Arrange
    when(requestService.getAllRequests()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/requests");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(requestController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link RequestController#getRequestById(Long)}
   */
  @Test
  void testGetRequestById() throws Exception {
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
    when(requestService.getRequestById(Mockito.<Long>any())).thenReturn(request);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/requests/{id}", 1L);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(requestController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "{\"id\":1,\"requestId\":\"42\",\"requestDescription\":\"Request Description\",\"requestTime\":[1970,1,1,0,0],"
                                    + "\"requestStatus\":\"Request Status\",\"requestPriority\":\"Request Priority\",\"requestLocation\":\"Request"
                                    + " Location\",\"requestCategory\":\"Request Category\",\"requestType\":\"Request Type\",\"requestFor\":\"Request"
                                    + " For\"}"));
  }

  /**
   * Method under test: {@link RequestController#createRequest(Request)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testCreateRequest() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.fpeng2288.requestservice.model.Request["requestTime"])
    //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
    //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1308)
    //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
    //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
    //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:772)
    //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
    //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:479)
    //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:318)
    //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4719)
    //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3964)
    //   See https://diff.blue/R013 to resolve this issue.

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
    String content = (new ObjectMapper()).writeValueAsString(request);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/requests")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act
    MockMvcBuilders.standaloneSetup(requestController).build().perform(requestBuilder);
  }

  /**
   * Method under test: {@link RequestController#deleteRequest(Long)}
   */
  @Test
  void testDeleteRequest() throws Exception {
    // Arrange
    doNothing().when(requestService).deleteRequest(Mockito.<Long>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/requests/{id}", 1L);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(requestController)
            .build()
            .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
  }

  /**
   * Method under test: {@link RequestController#deleteRequest(Long)}
   */
  @Test
  void testDeleteRequest2() throws Exception {
    // Arrange
    doNothing().when(requestService).deleteRequest(Mockito.<Long>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/requests/{id}", 1L);
    requestBuilder.contentType("https://example.org/example");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(requestController)
            .build()
            .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
  }

  /**
   * Method under test: {@link RequestController#updateRequest(Long, Request)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testUpdateRequest() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.fpeng2288.requestservice.model.Request["requestTime"])
    //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
    //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1308)
    //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
    //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
    //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:772)
    //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
    //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:479)
    //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:318)
    //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4719)
    //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3964)
    //   See https://diff.blue/R013 to resolve this issue.

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
    String content = (new ObjectMapper()).writeValueAsString(request);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/requests/{id}", 1L)
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act
    MockMvcBuilders.standaloneSetup(requestController).build().perform(requestBuilder);
  }
}
