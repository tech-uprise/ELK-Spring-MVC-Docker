#!/usr/bin/env bash

# start zookeeper
echo "Starting Zookeeper..."
#$KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties

nohup $KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties &

echo "Started Zookeeper..."


# start kafka
echo "Starting Kafka..."
#$KAFKA_HOME/bin/kafka-server-start.sh -daemon $KAFKA_HOME/config/server.properties

$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties

echo "Started Kafka..."

