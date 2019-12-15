Excellent docker networking -- bridge. https://www.javainuse.com/devOps/docker/docker-networking
 # I build the image
[1] #docker-springboot is a rest api producer
docker build  -t docker-springboot .


# run the container
docker run -p 9090:8080 docker-springboot
or be specific
docker container run --name restproducer -p 8080:8080 docker-springboot
or 
(first do: docker network create inter-communication)
docker container run --network inter-communication --name restproducer -p 8080:8080 docker-springboot

#get docker-machine ip 
docker-machine ip
192.168.99.100

put in etc/host
192.168.99.100 dockerdev
#---------------
C:\Users\sdass>docker network ls
NETWORK ID          NAME                  DRIVER              SCOPE
e69c31bf1b5c        bridge                bridge              local
d2ef39a5b658        host                  host                local
06fa0f1c8e28        inter-communication   bridge              local
7f95b9273b6e        none                  null                local


#---------------------
[2] #docker-consume is a rest consumer of above rest producer.
both [1] and [2] resides in two separate docker containers. 
Producer container when starts takes a name --name restproducer 
So, Consumer  when consume http call it calls the container name as if a host
String url = "http://restproducer:8080/hi";
result = restTemplate.getForObject(url, String.class);

Without in network. this resttemplate call error "host "restproducer" NO route"
Remedy is create a custom bridge network.
>docker network create inter-communication
>next: give producer the exact name that code will calling
>next: both producer and consumer pass --network name when starting container

#now consumer to run
docker run -p 8081:8081 docker-consume
or do this below
docker run --network inter-communication  -p 8081:8081 docker-consume 


# invoke with curl and test
C:\Users\sdass>curl http://dockerdev:9090/hi
say hello
----
see log output
2019-11-20 00:19:02.794  INFO 1 --- [nio-8080-exec-4] com.docker.springdocker.HelloController  : 

sayHello()...
