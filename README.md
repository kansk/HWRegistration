# HW Registration
## Version
1.0.0

## About
HW Registration is a simple user registration application.  It consists of a registration form to enter a user's name and address.  These registration forms are displayed via a sortable report.

## Usage
##### Installation
In order to build this application, you'll need to use Maven.  With Maven all you need to do is:
```sh
mvn install
```
This results in a WAR file which you can then deploy to your favorite Java application containter.  By default the application will use an in memory database, so if you want to use a different database such as MySQL, you'll need to configure that in the file:
```sh
/HWRegistration/src/main/resources/application.properties
```
## Stack

#### Front end components
  - Foundation
  - AngularJS
  - DataTables
  - Thymeleaf
#### Middle tier components
  - Spring Boot
  - Spring MVC
  - Spring Data
  - JPA/Hibernate
  - JUnit
#### Persistence
  - MySQL
  - H2
