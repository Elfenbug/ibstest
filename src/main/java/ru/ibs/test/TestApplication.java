package ru.ibs.test;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import ru.ibs.test.dto.PersonDto;

@SpringBootApplication
public class TestApplication {

    @KafkaListener(topics="msg")
    public void orderListener(ConsumerRecord<Long, PersonDto> record){
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
    }
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
