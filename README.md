# PollMan

## Overview
PollMan is a simple Poll Management System that allows users to create polls, vote on them, and view existing polls and their results. The application is built using **Java**, **Spring Boot**, and utilizes **H2 Database** for data storage. The front-end is developed using **Thymeleaf** for seamless integration with the back-end.

## Features
- **Create Polls**: Users can create new polls with multiple questions and options.
- **Vote on Polls**: Users can participate in polls by selecting their preferred options.
- **View Polls and Results**: Users can view all available polls and the results of their votes.

## Technologies Used
- **Java**: Programming language used to build the application.
- **Spring Boot**: Framework for creating stand-alone, production-grade Spring-based applications.
- **H2 Database**: In-memory database for quick data storage and retrieval during development.
- **Thymeleaf**: Server-side Java template engine for web and standalone environments.

## Getting Started

### Prerequisites
- Ensure you have Java Development Kit (JDK) 11 or higher installed.
- Install Maven for dependency management.

### Clone the Repository
To get started with the project, clone the repository to your local machine:

```
git clone https://github.com/omerkuzur/PollMan.git
cd PollMan 
```

### Build the Project
Navigate to the project directory and build the project using Maven:

```
mvn clean install
```

### Run the Application
You can run the Spring Boot application using the following command:

```
mvn spring-boot:run
```

### Access the Application
Open your web browser and go to:

```
http://localhost:8080
```

### Database Configuration
This project uses an H2 in-memory database. The database schema will be created automatically on startup.

### Contributing
If you'd like to contribute to this project, please fork the repository and submit a pull request with your changes.

### License
This project is licensed under the MIT License - see the LICENSE file for details.

### Acknowledgments
Inspired by various projects that focus on polling systems.
Thanks to the Spring Boot and Thymeleaf communities for their extensive documentation and support.
