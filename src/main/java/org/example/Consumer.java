package org.example;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class Consumer {
    public static void main(String [] args){
        //setting the consumer properties
        Properties properties = new Properties();
        properties.put("group.id", "test-group");
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        //createing consumer
        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Collections.singletonList("test-topic"));

        //polling
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String,String> record : records){
                System.out.println("Received message: " + record.value());
            }
        }
    }
}
