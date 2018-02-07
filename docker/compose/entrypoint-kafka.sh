#!/usr/bin/env bash


	sed -i "s|broker.id=0|$KAFKA_BROKER_ID|g" $WORKING_DIR/server.properties
	sed -i "s|PLAINTEXT://your.host.name:9092|$KAFKA_ADVERTISED_LISTENERS|g" $WORKING_DIR/server.properties
	sed -i "s|PLAINTEXT://:9092|$LISTENERS|g" $WORKING_DIR/server.properties
		
	cp $WORKING_DIR/server.properties $KAFKA_HOME/config/server.properties

# start zookeeper
echo "Starting Zookeeper..."

nohup $KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties &

echo "Started Zookeeper..."


# start kafka
echo "Starting Kafka..."

$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties

echo "Started Kafka..."

