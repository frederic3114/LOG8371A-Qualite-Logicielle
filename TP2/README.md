# TP2 - Weka API

## Getting started

1. Install git
```shell
sudo apt install git
```

2. Clone git repo
```shell
git clone https://github.com/frederic3114/LOG8371A-Qualite-Logicielle
```

3. Navigate to correct folder
```shell
cd LOG8371A-Qualite-Logicielle/TP2
```

4. Install Maven
```shell
sudo apt install maven
```

5. Build project
```shell
mvn clean package
```

6. Install Docker & create user group to avoid having to use Sudo
```shell
sudo snap install docker;
sudo groupadd docker;
sudo usermod -aG docker $USER;
```

7. Install & run Mongo
```shell
docker pull mongo;
docker run --name mongodb -d mongo;
```

8. Build Docker
```shell
docker build -t dizco/jguweka:OAS3 .
```

9. Run Docker container
```shell
docker run -p 8080:8080 --link mongodb:mongodb dizco/jguweka:OAS3
```

Using Postman, trigger a request