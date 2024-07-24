package com.deliveryBoy.Service;

import com.deliveryBoy.Configuration.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean updateLocation(String location) {
        try {
                this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
                logger.info("Message produced successfully.");
                System.out.println("----------------------------------------------------------------");

            return true;
        } catch (Exception e) {
            logger.error("Update location failed.", e);  // Using logger.error to log exceptions
            return false;
        }
    }
}
