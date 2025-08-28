package org.upskillher.models;

import java.util.HashMap;
import java.util.Map;

public class MessageData {

    public static Map<String, Object> createMessage(
            String name, String email, String phone,
            String subject, String description) {

        Map<String, Object> messageBody = new HashMap<>();
        messageBody.put("name", name);
        messageBody.put("email", email);
        messageBody.put("phone", phone);
        messageBody.put("subject", subject);
        messageBody.put("description", description);

        return messageBody;
    }
}