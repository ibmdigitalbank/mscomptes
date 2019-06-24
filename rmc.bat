@ECHO OFF
ECHO mscomptes
docker stop mscomptes
docker rm mscomptes
docker rmi ibmdigitalbank/mscomptes
docker build . -t ibmdigitalbank/mscomptes
docker run --network mynet -d -p 8081:8080 --name mscomptes ibmdigitalbank/mscomptes
docker logs mscomptes
PAUSE