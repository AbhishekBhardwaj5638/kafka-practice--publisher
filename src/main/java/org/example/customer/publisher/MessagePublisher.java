package org.example.customer.publisher;

import com.ibm.gbs.schema.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessagePublisher {

    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(Customer customerEvent) {
        log.info("sending  Event {}", customerEvent.getCustomerId());
        kafkaTemplate.send(topic, customerEvent.getAccountId(),customerEvent);
    }
}
