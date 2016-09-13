# ExampleSpringBootJerseyREST

## For running the example

PS. A the moment you need to create a schema in the PostgeSQL manually

```
cd ./ExampleSpringBootJerseyREST
mvn package
docker-compose up -d
java -jar ./target/school-raduga-example-1.0-SNAPSHOT.jar
```

Then you can run the curl requests to the RESTful micro service

For creating a user:
```
curl -vvv -H "Content-Type: application/json" -X POST -d '{"name": "boo foo"}' http://localhost:8080/user

*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> POST /user HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.43.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 19
> 
* upload completely sent off: 19 out of 19 bytes
< HTTP/1.1 200 OK
< Date: Tue, 13 Sep 2016 07:10:58 GMT
< Content-Type: application/json
< Content-Length: 62
< 
* Connection #0 to host localhost left intact
{"id":"e6e53197-1a77-4646-9ce0-90d10e01a750","name":"boo foo"}
```

For getting the user:
```
curl -vvv http://localhost:8080/user/e6e53197-1a77-4646-9ce0-90d10e01a750

*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> GET /user/e6e53197-1a77-4646-9ce0-90d10e01a750 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.43.0
> Accept: */*
> 
< HTTP/1.1 200 OK
< Date: Tue, 13 Sep 2016 07:11:57 GMT
< Content-Type: application/json
< Content-Length: 62
< 
* Connection #0 to host localhost left intact
{"id":"e6e53197-1a77-4646-9ce0-90d10e01a750","name":"boo foo"}
```

