# 3rivers
The following was discovered as part of building this project:

* In this project we have one Kafka consumer which is consuming messages from "account-feed" topic and update the db based on feed.
* I have implemented two API as per requirement.
* I am taking H2 DB for storage as of now because just to avoid extra configuration steps, so that anyone can run the project without additional effort.
* In application.properties first we need to update the credentials and URL of Kafka broker before starting this application
* The original package name 'com.3rivers' is invalid and this project uses 'com.rivers' instead.
* I have developed this on springboot - 2.4.2 and Java 11
* for building this application - mvn clean install
* Once the jar is created in target folder 3rivers-1.0.0.jar : java -jar 3rivers-1.0.0.jar
* URL : For getting account balance : GET: http://localhost:8080/balance/{accountNumber}
* URL  : For Getting Transactions :GET : http://localhost:8080/transaction/{accountNumber}?accountNumber=10004&range=today&page=1&size=5&type=DEPOSITE&fromdate=2020-01-01&todate=2020-01-23
* Possible vales of range : today, last_week, last_month
* default page : 0 , Default page size = 10
* Optional Parameters : page and size
* you can either send range or you can send to & from


# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.2/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#using-boot-devtools)
* [Apache Kafka Streams Support](https://docs.spring.io/spring-kafka/docs/current/reference/html/_reference.html#kafka-streams)
* [Apache Kafka Streams Binding Capabilities of Spring Cloud Stream](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/#_kafka_streams_binding_capabilities_of_spring_cloud_stream)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-kafka)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Samples for using Apache Kafka Streams with Spring Cloud stream](https://github.com/spring-cloud/spring-cloud-stream-samples/tree/master/kafka-streams-samples)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
