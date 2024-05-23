package com.fpeng2288.requestservice.controller;

import com.fpeng2288.requestservice.model.Request;
import com.fpeng2288.requestservice.service.RequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
@Tag(name = "Request Management", description = "Operations pertaining to help requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping
    @Operation(summary = "View a list of available requests", description = "Returns a list of all help requests")
    public List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a request by Id", description = "Returns a help request based on its ID")
    public Request getRequestById(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new request", description = "Creates a new help request")
    public Request createRequest(@RequestBody Request request) {
        return requestService.saveRequest(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing request", description = "Updates an existing help request based on its ID")
    public Request updateRequest(@PathVariable Long id, @RequestBody Request request) {
        Request existingRequest = requestService.getRequestById(id);
        if (existingRequest != null) {
            existingRequest.setRequestId(request.getRequestId());
            existingRequest.setRequestDescription(request.getRequestDescription());
            existingRequest.setRequestTime(request.getRequestTime());
            existingRequest.setRequestStatus(request.getRequestStatus());
            existingRequest.setRequestPriority(request.getRequestPriority());
            existingRequest.setRequestLocation(request.getRequestLocation());
            existingRequest.setRequestCategory(request.getRequestCategory());
            existingRequest.setRequestType(request.getRequestType());
            existingRequest.setRequestFor(request.getRequestFor());
            return requestService.saveRequest(existingRequest);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a request by Id", description = "Deletes a help request based on its ID")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}
