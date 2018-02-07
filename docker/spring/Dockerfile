# Pull the base image for tomcat
FROM tomcat:8-jre8

ENV TOMCAT_HOME /usr/local/tomcat
ENV ELK_PROP_PATH $ELK_PROP_PATH


# Copy images to tomcat path
ADD elk-spring-mvc-web.war $TOMCAT_HOME/webapps/
ADD entrypoint-tomcat.sh /usr/local/scripts/

RUN chmod 755 /usr/local/scripts/entrypoint-tomcat.sh

WORKDIR /usr/local/scripts

EXPOSE 8080

ENTRYPOINT ["/usr/local/scripts/entrypoint-tomcat.sh"]
