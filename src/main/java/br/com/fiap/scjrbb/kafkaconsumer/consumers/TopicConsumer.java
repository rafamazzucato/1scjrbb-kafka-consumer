package br.com.fiap.scjrbb.kafkaconsumer.consumers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicConsumer {

    @Value("${topic.name.consumer}")
    private String topicName;

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TopicConsumer.class);

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload){
        logger.info("Tópico {}", topicName);
        logger.info("Key {}", payload.key());
        logger.info("Headers {}", payload.headers());
        logger.info("Partition {}", payload.partition());
        logger.info("Message {}", payload.value());
    }
}
