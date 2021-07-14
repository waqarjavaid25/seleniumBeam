mvn clean package  -DskipTests
docker image rm -f docker-test
docker build -t docker-test .
docker compose down
docker compose up
