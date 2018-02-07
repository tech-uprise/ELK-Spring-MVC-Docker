package com.wal.monkeys.util;

public class ApplicationProperties {
	
	private String kafkaHost;
	private String kafkaPort;
	private String kafkaTpoic;
	
	public String getKafkaHost() {
		return kafkaHost;
	}
	public void setKafkaHost(String kafkaHost) {
		this.kafkaHost = kafkaHost;
	}
	public String getKafkaPort() {
		return kafkaPort;
	}
	public void setKafkaPort(String kafkaPort) {
		this.kafkaPort = kafkaPort;
	}
	public String getKafkaTpoic() {
		return kafkaTpoic;
	}
	public void setKafkaTpoic(String kafkaTpoic) {
		this.kafkaTpoic = kafkaTpoic;
	}

}
