package io.confluent.developer.spring.avro;

import io.confluent.developer.v2User;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@CommonsLog(topic = "Consumer Logger")
public class Consumer {

  @Value("${topic.name}")
  private String topicName;

  @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(ConsumerRecord<String, v2User> record) {
    log.info(String.format("Consumed message -> %s", record.value()));
  }
}