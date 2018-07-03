The application was created using Spring Boot. It requires Java 8 (was compiled using JDK 1.8.0_171 and might not work on newer Java versions).

The application can be run by executing the command "java -jar <path-to-jar-file>/exercise-0.1.0.jar". It deploys Tomcat server, which uses port 8080, so that port should be free during the test.

Once run, the application creates an H2 database. You can access it by opening your browser and navigating to "http://localhost:8080/h2/".

Login Settings
-------
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:~/test
User Name: bla1r84
Password: 12345

You can use Postman to test the application.
Available options:
- POST saveUser
example: 
localhost:8080/exercise/saveUser
Body example:
{"firstName": "Ioannis", "lastName": "Lilimpakis", "email": "lilimpakis@yahoo.gr", "gender": "Male", "ipAddress": "192.168.1.2" }

- GET getUser
example:
localhost:8080/exercise/getUser?ipAddress=192.168.1.2
or
localhost:8080/exercise/getUser?email=lilimpakis@yahoo.gr

- GET getAllUsers
example:
localhost:8080/exercise/getAllUsers
which will return all the users in the database.