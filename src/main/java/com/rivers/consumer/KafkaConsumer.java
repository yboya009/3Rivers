package com.rivers.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.rivers.service.KafkaService;

@Component
public class KafkaConsumer {
	
	@Autowired
	KafkaService kafkaService;
	
	@KafkaListener(topics = "${listener.topic}", groupId = "channel1")
	public void listen(ConsumerRecord<String, String> record) throws Exception {
		kafkaService.receive(record);
	}

}