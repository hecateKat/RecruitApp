package com.kat.recruitapp.services.Impl;

import com.kat.recruitapp.entities.UserEntity;
import com.kat.recruitapp.enums.PreferredNotificationChannel;
import com.kat.recruitapp.services.TransactionMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TransactionMessageServiceImpl implements TransactionMessageService {

    String msg = "Sending ${channel} to: ${recipient}, ${content}";

    Map<PreferredNotificationChannel, Map<String, String>> valuesByNotificationChannel = Map.of(
            PreferredNotificationChannel.EMAIL, Map.of("channelType", "email"),
            PreferredNotificationChannel.SMS, Map.of("channelType", "sms")
    );

    @Override
    public void sendInformationAboutTransaction(UserEntity user, String message) {
        String formattedMessage = messageFormatting(
                user.getPreferredNotificationChannel(),
                resolveRecipientAddressType(user),
                message);

        log.info(formattedMessage);
    }

    private String messageFormatting(PreferredNotificationChannel channel, String recipient, String message){
        Map<String, String> valuesMap = new HashMap<>(valuesByNotificationChannel.get(channel));
        valuesMap.put("recipient", recipient);
        valuesMap.put("content", message);

        StringSubstitutor stringSubstitutor = new StringSubstitutor(valuesMap);

        return stringSubstitutor.replace(msg);
    }

    private String resolveRecipientAddressType(UserEntity user) {
        return switch (user.getPreferredNotificationChannel()) {
            case SMS -> user.getPhoneNumber();
            case EMAIL -> user.getEmail();
        };
    }
}
