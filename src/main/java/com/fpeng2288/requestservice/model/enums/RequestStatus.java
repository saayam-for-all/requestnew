package com.fpeng2288.requestservice.model.enums;

/**
 * ClassName: RequestStatus
 * Package: com.fpeng2288.requestservice.model.enums
 * Description: Represents various states a help request can transition through.
 *
 * @author Fan Peng
 * Create 2024/5/16 16:08
 * @version 1.0
 */
public enum RequestStatus {
    CREATED,
    PENDING,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}
