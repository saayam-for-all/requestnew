package org.sfa.request.controller;

import org.sfa.request.constant.SaayamStatusCode;
import org.sfa.request.response.PagedResponse;
import org.sfa.request.model.entity.Request;
import org.sfa.request.dto.RequestDTO;
import org.sfa.request.service.api.RequestService;
import org.sfa.request.response.SaayamResponse;
import lombok.RequiredArgsConstructor;
import org.sfa.request.utils.JsonConverter;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.servlet.LocaleResolver;
import org.sfa.request.service.api.SQSService;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * ClassName: RequestController
 * Package: org.sfa.request.controller
 * Description:
 *
 * @author Fan Peng
 * Create 2024/6/15 1:51
 * @version 1.0
 */
@Validated
@RestController
@RequestMapping("/api/v1.0.0/requests/{requesterId}")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;
    private final LocaleResolver localeResolver;
    private final SQSService sqsService;
    private final MessageSource messageSource;

    @PostMapping
    public ResponseEntity<SaayamResponse<Request>> createRequest(
            @PathVariable @NotNull String requesterId,
            @RequestBody @Valid RequestDTO requestDTO,
            HttpServletRequest request
    ) {
        requestDTO.setRequesterId(requesterId);
        Locale locale = localeResolver.resolveLocale(request);
        SaayamResponse<Request> response = requestService.createRequest(requesterId, requestDTO, locale);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<SaayamResponse<Request>> getRequestById(
            @PathVariable @NotNull String requesterId,
            @PathVariable @NotNull String requestId,
            HttpServletRequest request
    ) {
        Locale locale = localeResolver.resolveLocale(request);
        SaayamResponse<Request> response = requestService.getRequestById(requesterId, requestId, locale);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<SaayamResponse<PagedResponse<Request>>> getRequests(
            @PathVariable @NotNull String requesterId,
            Pageable pageable,
            HttpServletRequest request
    ) {
        Locale locale = localeResolver.resolveLocale(request);
        SaayamResponse<PagedResponse<Request>> response = requestService.getRequests(requesterId, pageable, locale);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{requestId}")
    public ResponseEntity<SaayamResponse<Request>> updateRequest(
            @PathVariable @NotNull String requesterId,
            @PathVariable @NotNull String requestId,
            @RequestBody @Valid RequestDTO requestDTO,
            HttpServletRequest request
    ) {
        requestDTO.setRequesterId(requesterId);
        Locale locale = localeResolver.resolveLocale(request);
        SaayamResponse<Request> response = requestService.updateRequest(requesterId, requestId, requestDTO, locale);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<SaayamResponse<Void>> deleteRequest(
            @PathVariable @NotNull String requesterId,
            @PathVariable @NotNull String requestId,
            HttpServletRequest request
    ) {
        Locale locale = localeResolver.resolveLocale(request);
        SaayamResponse<Void> response = requestService.deleteRequest(requesterId, requestId, locale);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{requestId}/cancel")
    public ResponseEntity<SaayamResponse<Request>> cancelRequest(
            @PathVariable @NotNull String requesterId,
            @PathVariable @NotNull String requestId,
            HttpServletRequest request
    ) {
        Locale locale = localeResolver.resolveLocale(request);
        SaayamResponse<Request> response = requestService.cancelRequest(requesterId, requestId, locale);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{requestId}/resume")
    public ResponseEntity<SaayamResponse<Request>> resumeRequest(
            @PathVariable @NotNull String requesterId,
            @PathVariable @NotNull String requestId,
            HttpServletRequest request
    ) {
        Locale locale = localeResolver.resolveLocale(request);
        SaayamResponse<Request> response = requestService.resumeRequest(requesterId, requestId, locale);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{requestId}/sendToQueue")
    public ResponseEntity<SaayamResponse<Void>> sendRequestToQueue(
            @PathVariable @NotNull String requesterId,
            @PathVariable @NotNull String requestId,
            HttpServletRequest request
    ) {
        Locale locale = localeResolver.resolveLocale(request);
        SaayamResponse<Request> requestResponse = requestService.getRequestById(requesterId, requestId, locale);
        Request foundRequest = requestResponse.getData();

        String message = JsonConverter.convertRequestToJson(foundRequest);
        sqsService.sendMessage(message);

        String successMessage = messageSource.getMessage("success.requestSentToQueue", new Object[]{requestId}, locale);
        return ResponseEntity.ok(SaayamResponse.success(SaayamStatusCode.REQUEST_SENT_TO_QUEUE, successMessage, null));
    }
}