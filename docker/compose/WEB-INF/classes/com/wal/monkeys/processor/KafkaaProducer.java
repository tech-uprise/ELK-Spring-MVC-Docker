package com.wal.monkeys.processor;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wal.monkeys.model.User;
import com.wal.monkeys.util.ApplicationConfig;
import com.wal.monkeys.util.ApplicationProperties;
import com.wal.monkeys.util.JsonUtil;

public class KafkaaProducer {
	public void publishMessage(User user) {	
		try {
	    		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
			ApplicationProperties applicationProperties = context.getBean(ApplicationProperties.class);

			ObjectMapper objectMapper = new ObjectMapper();
			
			String userObjString = objectMapper.writeValueAsString(user);
			
			Producer<String, String> producer = new KafkaProducer<String, String>(getProducerProperties(getKafkaHostPort(applicationProperties)));
			
			System.out.println("About to send the message to the topic...");

			System.out.println(
					"Kafka host::: " +applicationProperties.getKafkaHost() 
					+ " Kafka port::: "+applicationProperties.getKafkaPort() 
					+ " Kafka Topic::: "+applicationProperties.getKafkaTpoic()
					);
			
			producer.send(new ProducerRecord<String, String>(getTopicName(applicationProperties), userObjString));
					
			System.out.println("Message sent to topic: "
					+ applicationProperties.getKafkaTpoic() 
					+ " Message: " +userObjString);
			
			producer.close();
			context.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private Properties getProducerProperties(String hostport) {
        Properties props = new Properties();
        props.put("bootstrap.servers", hostport);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 1638400);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 935544320);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");;
        return props;
    }
    
    private String getKafkaHostPort(ApplicationProperties applicationProperties) {

		String kafkaHostPort =  applicationProperties.getKafkaHost()+ ":" +applicationProperties.getKafkaPort();	
		System.out.println("Kafka Host and Port: "+kafkaHostPort);		
		return (kafkaHostPort);
    	
    }
  
    private String getTopicName(ApplicationProperties applicationProperties) {
    		return (applicationProperties.getKafkaTpoic());
    }

	
	public String getJson(User user) {	
		JsonUtil jsonUtil = new JsonUtil();
		String jsonString = jsonUtil.returnJson(user);
		
		return (jsonString);
		
	}

}
