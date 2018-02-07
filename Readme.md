This is a Spring MVC web application built using the following components. 
a.	Spring v4.3.9
b.	Elasticsearch v5.4
c.	Logstash v5.4
d.	Kibana v5.4
e.	Kafka v0.10.2.0

Its built using and can be deployed as docker. It can be built using docker compose. 
Download and install docker & docker compose from docker.com and follow the below steps to build docker images and deploy on docker containers.

1.	Clone the repo or download as zip file.
2.	Extract and zip file and step into docker and further into docker.
3. 	Open ".env" file under docker/compose using your favorite editor and and replace all the "localhost" to your machine IP or host.
4.	Open command line editor/terminal and go into docker folder (where you saved or cloned the repo).
5. 	To build docker images and deploy docker container - run this command: docker-compose up --build
6. To check if elasticsearch is running:
	-	Open your favorite browser and type in the following URL and hit go: http://your-host:9200
7. To access spring based web application:
	-	Open your favorite browser and type in the following URL and hit go: http://your-host:8080/elk-spring-mvc-web
8.	To start using and build dashboards in Kibana:
	-	Open your favorite browser and type in the following URL and hit go:  http://your-host:5601

Thats about it.

Here are some useful docker commands:

1.	To build the Docker images: 
		docker-compose build
2.	docker-compose build fails 
		change the version to 2 in docker-compose.yml file
3.	To start the application run:
		docker-compose up -d
4.	To shut down the application and keep users' data:
		docker-compose down
5.	To shut down the application and delete users' data:
		docker-compose down -v
6.	To build images after changing any content:
		docker-compose build
7.	To show running containers:
		docker ps
8.	To also show stopped containers:
		docker ps -a
9.	To list images:
		docker images
10.	To remove all the containers: 
		docker rm $(docker ps -aq)
11.	To remove all the images:
		docker rmi $(docker images -q)
12.	To go inside the running container:
		docker exec -it <container_name/container_id> bash