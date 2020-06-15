package io.confluent.developer.spring.avro;

import io.confluent.developer.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class KafkaController {

  private final Producer producer;

  @Autowired
  KafkaController(Producer producer) {
    this.producer = producer;
  }

  @PostMapping(value = "/v1/publish")
  public void v1sendMessageToKafkaTopic(@RequestParam("name") String name, @RequestParam("age") Integer age) {
    this.producer.sendMessage(new User(name, age));
  }

  @PostMapping(value = "/v2/publish")
  public void v2sendMessageToKafkaTopic(@RequestParam("name") String name, @RequestParam("age") Integer age) {
    this.producer.sendMessage(new User(name, age));
  }
  
}

