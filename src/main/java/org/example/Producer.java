package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String [] args){
        //setting the producer properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        //create the producer
        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<>(properties);

        //send the message
        ProducerRecord<String,String> record = new ProducerRecord<>("test-topic","key1","Hello, Kafka!");
        kafkaProducer.send(record);

        //close the producer
        kafkaProducer.close();
    }
}
