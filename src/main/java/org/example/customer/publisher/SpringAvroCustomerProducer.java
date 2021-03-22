package org.example.customer.publisher;



import com.ibm.gbs.schema.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAvroCustomerProducer implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(SpringAvroCustomerProducer.class,args);
    }
    @Autowired MessagePublisher messagePublisher;

    @Override
    public void run(String... args) {

        for (long nEvents = 0 ;nEvents <=4; nEvents++){
            Customer customer = new Customer();
            customer.setCustomerId(Long.toString(nEvents));
            customer.setPhoneNumber("123456789"+nEvents);
            customer.setAccountId("acc-00"+nEvents);
            customer.setName("abhi");
            messagePublisher.send(customer);
        }


    }
}
