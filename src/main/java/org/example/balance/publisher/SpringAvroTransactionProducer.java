package org.example.balance.publisher;

import com.ibm.gbs.schema.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAvroTransactionProducer implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringAvroTransactionProducer.class, args);
    }

    @Autowired TransactionMessagePublisher transactionMessagePublisher;

    @Override
    public void run(String... args)  {
        for (long nEvents = 0; nEvents < 4; nEvents++) {
            Transaction transaction = new Transaction();
            transaction.setBalanceId(Long.toString(nEvents));
            transaction.setBalance((float) (nEvents*1.22*10));
            transaction.setAccountId("acc-0"+nEvents);
            transactionMessagePublisher.send(transaction);
        }
    }
}
