package org.sfa.request.service.api;

public interface SqsService {
    public void sendMessage(String queueUrl, String phone, String email);
}
