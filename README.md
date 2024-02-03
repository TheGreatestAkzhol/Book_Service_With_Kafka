Book_Service_With_Kafka
Kafka Neccessary image in docker: docker run -p 2181:2181 -p 9092:9092 -e ADVERTISED_HOST=127.0.0.1 -e NUM_PARTITIONS=10 johnnypark/kafka-zookeeper 
This image contains also kafka server and zookeeper all we need to do is specify path to them
