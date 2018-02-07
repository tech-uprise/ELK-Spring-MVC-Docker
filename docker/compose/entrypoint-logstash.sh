#!/usr/bin/env bash

echo

echo "Kafka host in Logstash = " $KAFKA_HOST_NAME


if [ ! -z "${KAFKA_HOST_NAME}" ]; then

	 sed -i "s|localhost:9092|$KAFKA_HOST_NAME:$KAFKA_PORT|g" $WORKING_DIR/logstash.conf
	
fi

if [ ! -z "${KAFKA_TOPIC_NAME}" ]; then

	sed -i "s|eslskibana|$KAFKA_TOPIC_NAME|g" $WORKING_DIR/logstash.conf

fi

if [ ! -z "${ELASTICSEARCH_HOST}" ]; then

	sed -i "s|localhost:9200|$ELASTICSEARCH_HOST:$ELASTICSEARCH_PORT|g" $WORKING_DIR/logstash.conf

fi

if [ ! -z "${ELASTICSEARCH_INDEX}" ]; then

	sed -i "s|spring_mvc_index|$ELASTICSEARCH_INDEX|g" $WORKING_DIR/logstash.conf

fi

echo "Starting Logstash ..."


$LOGSTASH_HOME/logstash-5.4.0/bin/logstash -f  $WORKING_DIR/logstash.conf

echo "Started Logstash and it's up and running..."


