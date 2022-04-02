## Set up Kafka in your operating system with 

- Copy the docker-compose.yml in your one path of your machine
- Go to the folder part where you are copy the docker-compose.yml file
- Run the command line
```bash
  docker-compose -f docker-compose.yml up -d
```
- After complete installing, run the command line to see all containers running
```bash
  docker ps
```
- Take the container id of  bitnami/kafka:latest
- Run the command line
```bash
  docker exec -it CONTAINER_ID /bin/sh
```
- Go to the bin folder of kafka
```bash
  cd /opt/bitnami/kafka/bin
```
- Then procede with some operations
    - to create topic: 
      ```bash
        kafka-topics.sh --create --topic TOPIC_NAME --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4
      ```
    - to see list of topics:
      ```bash
        kafka-topics.sh --list --bootstrap-server localhost:9092
      ```
    - to consume topic:
      ```bash
        kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic TOPIC_NAME --from-beginning
      ```