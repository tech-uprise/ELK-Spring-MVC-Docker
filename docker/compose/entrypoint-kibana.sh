#!/usr/bin/env bash

echo
echo "checking for env variable"

#if [ ! -z "${ELASTICSEARCH_HOST}" ]; then
	
	sed -i "s|localhost:9200|$ELASTICSEARCH_HOST:$ELASTICSEARCH_PORT|g" $WORKING_DIR/kibana.yml
	cp $WORKING_DIR/kibana.yml $KIBANA_HOME/kibana-5.4.0-linux-x86_64/config/kibana.yml
	
#fi

echo "Starting Kibana ..."

$KIBANA_HOME/kibana-5.4.0-linux-x86_64/bin/kibana


