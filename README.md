# Employee Tracking System

Employee Tracking System enables you to keep track of worker & hours and provide more accurate payroll data.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install to use the software.

```
Docker          | https://www.docker.com
ETS Docker File | https://github.com/ARDAKARABEL/ttweb/raw/master/ets.zip
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
Extract ets.zip where you want to compose the container.
Execute "docker-compose up" inside this folder.
Open any web browser and point to http://localhost
```

## Form Validation Tests

- New Record (Assert False)
  - Type E-Mail address like abc!abc.com
  - Leave Start & End Date Time Empty
  - Leave End Date Empty
  - Make Start & End Date equal
  
- New Record (Assert True)
  - Select/Type everything in proper format.
  
- Search Records
  - Type E-Mail and search.

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

