# Request Handler Microservice

## Overview

The Request Handler Microservice is designed to manage various types of service requests efficiently. It is built using [Spring Boot](https://spring.io/projects/spring-boot), a robust framework for developing Java-based applications. For more details on Spring Boot, you can refer to the [official documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/).

## Description

The Request Handler Microservice provides functionalities for creating, updating, deleting, and retrieving service requests. It supports various request categories and priorities, and it allows specifying whether the assistance is required in person or can be handled digitally.

## Running the Application Locally

To run the Request Handler Microservice on your local machine:

1. **Prerequisites**: Ensure Java (JDK 17), and Maven are installed. Additionally, Docker is required to set up local PostgreSQL servers. [Here](https://docs.docker.com/get-started/) is a helpful guide if you're new to Docker.

2. **Repository Setup**: Clone the repository and navigate to the root folder in the terminal.

3. **Database Setup**:
    - `requestservice_dev@localhost`
      - Host: `localhost`
      - Port: `5433`
      - Database: `requestservice_dev`
      - User: `requestuser`
      - Password: `123456`
    - `requestservice_test@localhost`
        - Host: `localhost`
        - Port: `5434`
        - Database: `requestservice_test`
        - User: `requestuser`
        - Password: `123456`
        

4. **Environment Configuration**: Create a `.env` file in the root folder, following the structure of the provided `.env.example`, and fill in the required environment variables.
    ```env
    DB_DEV_HOST=localhost
    DB_DEV_PORT=5433
    DB_DEV_USER=requestuser
    DB_DEV_PASSWORD=123456
    DB_DEV_NAME=requestservice_dev

    DB_TEST_HOST=localhost
    DB_TEST_PORT=5434
    DB_TEST_USER=requestuser
    DB_TEST_PASSWORD=123456
    DB_TEST_NAME=requestservice_test

    APP_DEV_PORT=8080
    APP_TEST_PORT=8081
    ```

5. **Build the Application**:
    ```bash
    mvn clean package
    ```
   Note: There are currently issues with tests, so the tests will be ignored by default in the `pom.xml` configuration.

6. **Run Docker Containers**:
    ```bash
    docker-compose down -v
    docker-compose up --build -d
    ```

### Using the Application

**Access the API**:

- **Development Mode**:
    - API: `http://localhost:8080`
    - Swagger UI: `http://localhost:8080/swagger-ui.html`

- **Test Mode**:
    - API: `http://localhost:8081`
    - Swagger UI: `http://localhost:8081/swagger-ui.html`

### Postman Setup

#### 1. Create Request
- **Name**: Create Request
- **Method**: POST
- **URL**: `http://localhost:8080/requests`
- **Headers**:
    - Key: `Content-Type`, Value: `application/json`
- **Body** (raw JSON):
    ```json
    {
      "requestId": "123",
      "requestDescription": "Test request",
      "requestTime": "2023-05-16T12:00:00",
      "requestStatus": "Pending",
      "requestPriority": "High",
      "requestLocation": "Location A",
      "requestCategory": "TECHNICAL_SUPPORT",
      "requestType": "DIGITAL",
      "requestFor": "User A"
    }
    ```
- **Expected Result**:
    - **Status Code**: 200 OK
    - **Response Body**:
      ```json
      {
        "id": 1,
        "requestId": "123",
        "requestDescription": "Test request",
        "requestTime": "2023-05-16T12:00:00",
        "requestStatus": "Pending",
        "requestPriority": "High",
        "requestLocation": "Location A",
        "requestCategory": "TECHNICAL_SUPPORT",
        "requestType": "DIGITAL",
        "requestFor": "User A"
      }
      ```

#### 2. Get All Requests
- **Name**: Get All Requests
- **Method**: GET
- **URL**: `http://localhost:8080/requests`
- **Expected Result**:
    - **Status Code**: 200 OK
    - **Response Body**: Contains all requests as a JSON array

#### 3. Get Request By ID
- **Name**: Get Request By ID
- **Method**: GET
- **URL**: `http://localhost:8080/requests/1` (assuming ID is 1)
- **Expected Result**:
    - **Status Code**: 200 OK
    - **Response Body**:
      ```json
      {
        "id": 1,
        "requestId": "123",
        "requestDescription": "Test request",
        "requestTime": "2023-05-16T12:00:00",
        "requestStatus": "Pending",
        "requestPriority": "High",
        "requestLocation": "Location A",
        "requestCategory": "TECHNICAL_SUPPORT",
        "requestType": "DIGITAL",
        "requestFor": "User A"
      }
      ```

#### 4. Update Request
- **Name**: Update Request
- **Method**: PUT
- **URL**: `http://localhost:8080/requests/1` (assuming ID is 1)
- **Headers**:
    - Key: `Content-Type`, Value: `application/json`
- **Body** (raw JSON):
    ```json
    {
      "requestId": "123",
      "requestDescription": "Updated request",
      "requestTime": "2023-05-16T12:00:00",
      "requestStatus": "Completed",
      "requestPriority": "High",
      "requestLocation": "Location B",
      "requestCategory": "FINANCIAL_SUPPORT",
      "requestType": "IN_PERSON",
      "requestFor": "User B"
    }
    ```
- **Expected Result**:
    - **Status Code**: 200 OK
    - **Response Body**:
      ```json
      {
        "id": 1,
        "requestId": "123",
        "requestDescription": "Updated request",
        "requestTime": "2023-05-16T12:00:00",
        "requestStatus": "Completed",
        "requestPriority": "High",
        "requestLocation": "Location B",
        "requestCategory": "FINANCIAL_SUPPORT",
        "requestType": "IN_PERSON",
        "requestFor": "User B"
      }
      ```

#### 5. Delete Request
- **Name**: Delete Request
- **Method**: DELETE
- **URL**: `http://localhost:8080/requests/1` (assuming ID is 1)
- **Expected Result**:
    - **Status Code**: 204 No Content

### Postman Test Collection

Add each of the above tests to a collection in Postman and execute them in the specified order. Each test should be configured with the appropriate request method, URL, and request body, and the response status code and body should be verified against the expected results.

## Current Progress

### Completed Features
- **CRUD Operations:** The microservice can create, read, update, and delete service requests.
- **Database Integration:** Integrated with PostgreSQL for persistent storage.
- **API Documentation:** Swagger is set up for API documentation.

### Pending Features
- **Comprehensive Testing:** More unit and integration tests need to be written.
- **Error Handling:** Robust error handling mechanisms need to be implemented.
- **Security:** Implement security features like authentication and authorization.
- **Performance Optimization:** Optimize the microservice for better performance under load.
- **AWS Step Functions Integration:** Update with AWS Step Functions for enhanced orchestration and automation.
