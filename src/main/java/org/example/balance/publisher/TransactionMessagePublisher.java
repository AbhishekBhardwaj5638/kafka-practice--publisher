package org.example.balance.publisher;

import com.ibm.gbs.schema.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionMessagePublisher {

    @Value("${kafka.topic}")
    private String topic ;

    @Autowired
    private KafkaTemplate kafkaTransactionTemplate;

    public void send(Transaction transaction) {
        log.info("sending Order Id Event {}", transaction.getBalanceId());
        kafkaTransactionTemplate.send(topic, transaction.getBalanceId(), transaction);
    }
}
