package org.example;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibm.gbs.schema.Customer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

public class CustomerBalanceEnrichment {

    private static Gson gson = new GsonBuilder().create();

    public static void main(String[] args) {
        //stream of data for customers

        //initializing the properties

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG,"customer-balance-enrichment");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:29092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG,0);

        final StreamsBuilder builder = new StreamsBuilder();

        KStream<String,String> customerInfo = builder.stream("customer-info");

//
//        KStream<String, String> customerBalanceKeyStream = customerInfo.selectKey((key,value)->{
//            Customer customer = gson.fromJson(value,Customer.class);
//            return customer.getAccountId();
//        });

        KStream<String,String> balInfo = builder.stream("bal-info");

    }


}
