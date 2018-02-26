package com.pge.ei.sample.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "${kafka.topic}", group = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
	public void processMessage(String content) {
		log.info("Recivedcontent::::::" + content);
		log.info("received content = '{}'", content);
	}
}
