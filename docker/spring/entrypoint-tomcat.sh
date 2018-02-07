#!/usr/bin/env bash

#start tomcat

$TOMCAT_HOME/bin/catalina.sh run


docker run -it --rm -p 8081:8081 --name spring-mvc-web spring-tomcat-server bash

