package com.endUser.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaConfig.class);
    @KafkaListener(topics = AppConstants.LOCATOIN_UPDATE_TOPIC,groupId =AppConstants.GROUP_ID )
    public void updateLocation(String value){
        System.out.println(value);

    }
}
