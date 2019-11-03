# teamworktrackerservice
Spring Boot Rest service for Teamwork tracker application

# Clone the project

git clone git@github.com:mounikakapilavai/teamworktrackerservice.git

This will download the project and creates a folder called teamworktrackerservice.

# Rebase the project

git pull --rebase git@github.com:chandan509/teamworktrackerservice.git

Push the code to your github.

git push origin master

# How to Build

cd teamworktrackerservice
mvn clean install or right click on project in eclipse and build

# How to Run

Run TeamworktrackerserviceApplication.java as a standalone java program. Application will be started on port 8083. You can change this port in application.properties file.

Enter below URL in address to see the REST API's
http://localhost:8083/teamworktrackerservice/swagger-ui.html