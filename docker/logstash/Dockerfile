
FROM openjdk:8

ENV LOGSTASH_HOME /usr/local/logstash
ENV LOGSTASH_SCRIPTS = /usr/local/scripts
ADD entrypoint-logstash.sh $LOGSTASH_SCRIPTS
ADD logstash.conf $LOGSTASH_SCRIPTS
RUN mkdir -p $LOGSTASH_HOME/logstash-5.4.0
 
# install logstash
	RUN wget https://artifacts.elastic.co/downloads/logstash/logstash-5.4.0.tar.gz && \
		tar -xvf logstash-5.4.0.tar.gz && \
		mv logstash-5.4.0 $LOGSTASH_HOME

 
		
RUN chmod 755 $LOGSTASH_SCRIPTS/entrypoint-logstash.sh
RUN chmod 755 $LOGSTASH_SCRIPTS/logstash.conf

WORKDIR $LOGSTASH_SCRIPTS
 

ENTRYPOINT ["/usr/local/scripts/entrypoint-logstash.sh"]