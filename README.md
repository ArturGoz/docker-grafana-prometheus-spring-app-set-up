# DOCKER GRAFANA PROMETHEUS SPRING APP SET UP



PROMETHEUS:

create docker :
cd C:\Users\artur\docker-prometheus
docker build -t my-prometheus .
docker run -d --name prometheus -p 9090:9090 my-prometheus


cd "C:\Users\artur\Downloads\prometheus-3.5.0.windows-amd64\prometheus-3.5.0.windows-amd64"
./prometheus --config.file=prometheus.yml

http://localhost:9090/query

users_count

GRAFANA: 

cd "C:\Program Files\GrafanaLabs\grafana\bin"
.\grafana-server.exe

docker run -d -p 3000:3000 --name grafana grafana/grafana

admin
admin

http://localhost:3000

add http://prometheus:9090


DOCKER :

NETWORK: 

docker network create spring-network
docker network connect spring-network mysql-container
docker network connect spring-network spring-app-container
docker network connect spring-network prometheus
docker network connect spring-network grafana

MYSQL:

docker run --name mysql-container `
-e MYSQL_ROOT_PASSWORD=Artur.14022005 `
-e MYSQL_DATABASE=isdb `
-d -p 3306:3306 mysql:8

SPRING APP : 

get : 
cd "D:\intelej projects\IS\IS-lab1"

docker build -t spring-app .

Run : 
docker run --name spring-app-container -p 8080:8080 -d spring-app



