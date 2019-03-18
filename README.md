# Employee Tracking System

Employee Tracking System enables you to keep track of worker & hours and provide more accurate payroll data.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install to use the software.

```
Docker        | https://www.docker.com
ETS Container | https://www.docker.com/products/docker-desktop
```

### Installing

A step by step series of examples that tell you how to get environment running.

Docker Installation

```
Download Docker from https://www.docker.com/products/docker-desktop
Run the installer.
Follow the Install Wizard: accept the license, authorize the installer, and proceed with the install.
Click Finish to launch Docker.
Docker starts automatically.
Docker loads a “Welcome” window giving you tips and access to the Docker documentation.
```

Pull Container

```
Open command line.
Execute "docker pull ardakarabel/timetracker" 
```

Run Application
```
docker run -d -p 80:80 ardakarabel/timetracker:1
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system


### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
* [Maven](https://maven.apache.org/) - Dependency Management
* [Make - Admin Template](https://themeforest.net/item/make-admin-template-builder-html-angularjs/10511387) - Admin Template & Builder - HTML & AngularJS

## Authors

* **Arda Karabel** - *Initial work* - [Arda.TK](https://www.arda.tk)

## Supplementary Resources

* [Spring MVC form handling example](https://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/)
* [Jquery Validations](https://jqueryvalidation.org/)
* [Docker Documentations](https://docs.docker.com/)

