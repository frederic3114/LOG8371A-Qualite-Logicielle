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

6. Install docker-compose
```shell
sudo apt install docker-compose
```

7. Build the container image
```shell
docker build -t jguweka/jguweka:OAS3 .
```

8. Run docker-compose
```shell
sudo docker-compose up
```

Using Postman or Swagger, trigger a request