package org.sfa.request.requesthandler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.sfa.request.requesthandler.BaseRequestHandler;
import org.sfa.request.constant.SaayamStatusCode;
import org.sfa.request.exception.types.InvalidRequestException;
import org.sfa.request.exception.types.NotFoundException;
import org.sfa.request.exception.handler.LambdaExceptionHandler;
import org.sfa.request.model.entity.Request;
import org.sfa.request.response.SaayamResponse;
import org.sfa.request.service.api.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.Locale;

/**
 * ClassName: CancelRequestHandler
 * Package: org.sfa.request.requesthandler
 * Description:
 *
 * @author Fan Peng
 * Create 2024/6/19 16:52
 * @version 1.0
 */
@Slf4j
public class CancelRequestHandler extends BaseRequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static final RequestService requestService = context.getBean(RequestService.class);

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent requestEvent, Context lambdaContext) {
        try {
            String requesterId = requestEvent.getPathParameters().get("requesterId");
            String requestId = requestEvent.getPathParameters().get("requestId");
            Locale locale = getLocaleFromRequest(requestEvent);

            log.info("Attempting to cancel request: {} for requester: {}", requestId, requesterId);
            SaayamResponse<Request> response = requestService.cancelRequest(requesterId, requestId, locale);

            log.info("Cancel operation result: {}", response);
            return createResponse(HttpStatus.OK.value(), response);
        } catch (NotFoundException e) {
            log.warn("Request not found in CancelRequestHandler: ", e);
            return createErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    SaayamStatusCode.REQUEST_NOT_FOUND,
                    e.getMessage()
            );
        } catch (InvalidRequestException e) {
            log.warn("Invalid request in CancelRequestHandler: ", e);
            return createErrorResponse(
                    HttpStatus.CONFLICT.value(),
                    SaayamStatusCode.REQUEST_CONFLICT,
                    e.getMessage()
            );
        } catch (Exception e) {
            log.error("Error in CancelRequestHandler: ", e);
            return LambdaExceptionHandler.handleException(e, lambdaContext, getLocaleFromRequest(requestEvent));
        }
    }
}