package org.sfa.request.service.impl;

import org.sfa.request.service.api.SqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.Map;

@Service
public class SqsServiceImpl implements SqsService {


    private final SqsClient sqsClient;

    @Autowired
    public SqsServiceImpl(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }


    public void sendMessage(String queueUrl, String phone, String email) {
        SendMessageRequest sendMessageRequest =
                SendMessageRequest.builder()
                        .queueUrl(queueUrl)
                        .messageBody("This is a SQS message")
                        .messageAttributes(Map.of(
                                "Phone", MessageAttributeValue.builder()
                                        .dataType("String")
                                        .stringValue(phone)
                                        .build(),
                                "Email", MessageAttributeValue.builder()
                                        .dataType("String")
                                        .stringValue(email)
                                        .build()
                        ))
                        .build();

        SendMessageResponse sendMessageResponse = sqsClient.sendMessage(sendMessageRequest);
        System.out.println("Message Sent: " + sendMessageResponse.messageId());
    }
}


