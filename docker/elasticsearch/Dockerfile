FROM openjdk:8-jre

ENV ELASTICSEARCH_HOME /usr/local/elasticsearch

ENV WORKING_DIR /usr/local/scripts

#RUN apt-get update && \
#      apt-get -y install sudo

RUN apt-get update && apt-get install -y procps
RUN groupadd elasticsearch
RUN useradd -ms /bin/bash -g elasticsearch elasticsearch && adduser elasticsearch sudo

WORKDIR $WORKING_DIR
ADD entrypoint-elasticsearch.sh $WORKING_DIR
RUN chown -Rv elasticsearch:elasticsearch $WORKING_DIR
RUN chmod -R 777 $WORKING_DIR

RUN mkdir -p $ELASTICSEARCH_HOME/elasticsearch-5.4.0

# install elasticsearch

	RUN wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-5.4.0.tar.gz && \
		tar -xvf elasticsearch-5.4.0.tar.gz && \
	mv elasticsearch-5.4.0 $ELASTICSEARCH_HOME

ADD elasticsearch.yml $ELASTICSEARCH_HOME/elasticsearch-5.4.0/config/elasticsearch.yml

RUN chown -Rv elasticsearch:elasticsearch $ELASTICSEARCH_HOME
RUN chmod -R 777 $ELASTICSEARCH_HOME

VOLUME ["$ELASTICSEARCH_HOME"]

RUN echo $(ls -ltr /usr/local/elasticsearch/elasticsearch-5.4.0/config)

EXPOSE 9200 9300

USER elasticsearch

ENTRYPOINT ["/usr/local/scripts/entrypoint-elasticsearch.sh"]