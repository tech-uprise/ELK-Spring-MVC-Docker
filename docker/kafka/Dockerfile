#FROM java:8
FROM openjdk:8
#FROM openjdk-8-jdk

ENV KAFKA_HOME /usr/local/kafka
ADD entrypoint-kafka.sh /usr/local/scripts/
 
# install java + others
#RUN apt-get update && apt-get install -y \
#  wget \
#  openjdk-8-jdk
 
# install kafka
	RUN wget https://archive.apache.org/dist/kafka/0.10.2.0/kafka_2.10-0.10.2.0.tgz && \
		tar -xvf kafka_2.10-0.10.2.0.tgz && \
		mv kafka_2.10-0.10.2.0 $KAFKA_HOME


EXPOSE 2181
EXPOSE 9092
 
RUN chmod 755 /usr/local/scripts/entrypoint-kafka.sh

WORKDIR /usr/local/scripts

ENTRYPOINT ["/usr/local/scripts/entrypoint-kafka.sh"]