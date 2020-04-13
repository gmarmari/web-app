A Simple Web-App, which is being developed on my free time. 

Project Requirements:
 * Java 11
 * Docker
 
 Maven:
  * Build: ./mvnw clean install
  * Run:    ./mvnw spring-boot:run -pl web
  
 Docker:
 * docker-compose build web-app : creates a docker image for the whole application
 * docker-compose up : starts everything (./mvnw clean install must have been executed first)
 * docker-compose up -d database : starts a database for local development
 * docker-compose down -v : remove all containers 