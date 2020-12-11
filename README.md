## Photographer POC for new joiners

#### The app is using H2 in-memory database for quick setup. It can be switched to MySQL easily if needed. The tables will be dropped when stopped and created when started.

### 1. To Run

```bash
./mvnw spring-boot:run

# if maven exist
mvn spring-boot:run
```

### 2. Check in Browser

```
http://localhost:8080/categories
```

### 3. Docker Commands

Build Image:
```
docker build -f Dockerfile -t photographer .
```
Run Image:
```
docker run --restart=always -d -p 8080:8080 --name photographerContainer photographer
```