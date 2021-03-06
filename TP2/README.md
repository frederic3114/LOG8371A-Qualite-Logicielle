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
sudo docker build -t jguweka/jguweka:OAS3 .
```

8. Run docker-compose
```shell
sudo docker-compose up
```

Using Postman or Swagger, trigger a request

REST API can be accessed through port 8081 on any hostname associated with the machine running Docker (localhost, 127.0.0.1, etc)

## Setting up JProfiler 

1. Download and install JProfiler GIU from the following link: 
```shell
https://www.ej-technologies.com/download/jprofiler/files
```

2. Launch JProfiler and activate the trial version.

3. To start profiling with JProfiler, start a new session with the following steps
```shell
Session -> New Session -> Name your session 
Select the Attach option -> Attach to remote JVM
Enter the IP Adress of the running Docker Container that you are profiling.
Leave the Profiling port as default, 8849 -> Leave other settings as default -> click OK
Evaluate -> Leave settings as default -> Ok
The profiling should be running just fine.
```



## Setting up load testing with JMeter

1. Download and extract JMeter
```shell
wget http://muug.ca/mirror/apache-dist//jmeter/binaries/apache-jmeter-5.1.1.zip
unzip apache-jmeter-5.1.1.zip
```

2. Launch JMeter GUI (optional)
```shell
cd apache-jmeter-5.1.1/bin/
./jmeter
```

3. Create a new test plan (optional)
```
A tutorial on creating the test plan can be found https://www.guru99.com/jmeter-performance-testing.html
```

4. Run the pre-existing test plans
```shell
./jmeter -n -t PATH_TO_REPO/TP2/jmeter_tests/lt_{bayes | custom}_{low | medium | high | very_high}.jmx
```
The provided plans assume that you are running Docker locally and that it can be accessed through localhost:8081
- Low         : 1    threads (users) on 10   loops
- Medium      : 10   threads (users) on 100  loops
- High        : 100  threads (users) on 1000 loops
- Very High   : 1000 threads (users) on 1000 loops


## Scale
1. Build the container image
```shell
sudo docker build -t jguweka/jguweka:OAS3 .
```

2. Run docker-compose
```shell
sudo docker-compose up --scale jguweka=2
```

3. Open a new terminal and run
```shell
docker stats
```

4. Use Postman to trigger requests. The API is now available on `http://localhost:80`
