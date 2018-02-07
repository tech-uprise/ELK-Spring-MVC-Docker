#!/usr/bin/env bash


if [ ! -z "${KAFKA_HOST_NAME}" ]; then

	sed -i "s|localhost|$KAFKA_HOST_NAME|g" $WORKDIR/elk.properties
	
	sed -i "s|9092|$KAFKA_PORT|g" $WORKDIR/elk.properties
	
	sed -i "s|eslskibana|$KAFKA_TOPIC_NAME|g" $WORKDIR/elk.properties
	
fi

#start tomcat

$TOMCAT_HOME/bin/catalina.sh run






