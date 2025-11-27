# Welcome Event System

This repository contains a two-module Spring Boot project demonstrating
a simple event-driven architecture using **RabbitMQ**. The system
consists of:

-   **Publisher**: Sends a `UserCreatedEvent` message when a user
    registers.
-   **Consumer**: Listens to the queue and processes the incoming event.

## 🏗 Project Structure

    welcome/
     ├── consumer/   # Spring Boot consumer application
     └── publisher/  # Spring Boot publisher application

## 📦 Technologies Used

-   Java 21
-   Spring Boot
-   Spring AMQP (RabbitMQ)
-   Maven
-   Docker (optional for RabbitMQ)
-   Lombok

## 🚀 How It Works

### Publisher

-   Exposes a REST endpoint that accepts user registration data.
-   Publishes a `UserCreatedEvent` to a RabbitMQ exchange.
-   Key classes:
    -   `RegistrationController`
    -   `RegistrationService`
    -   `RabbitMQConfig`
    -   `UserCreatedEvent`

### Consumer

-   Listens to the same RabbitMQ queue.
-   Handles the incoming `UserCreatedEvent`.
-   Logs or processes the event.
-   Key classes:
    -   `RabbitMQConfig`
    -   `UserCreatedEventHandler`
    -   `UserCreatedEvent`

## ▶️ Running the Project

### 1. Start RabbitMQ

Using Docker:

``` bash
docker run -it --rm -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

Management UI: http://localhost:15672\
User/pass: `guest / guest`

### 2. Run Publisher

``` bash
cd welcome/publisher
./mvnw spring-boot:run
```

### 3. Run Consumer

``` bash
cd welcome/consumer
./mvnw spring-boot:run
```

### 4. Test Publishing

``` bash
curl -X POST http://localhost:8080/api/register -H "Content-Type: application/json" -d '{"name":"John","email":"john@example.com"}'
```

You should see the event consumed on the consumer application console.