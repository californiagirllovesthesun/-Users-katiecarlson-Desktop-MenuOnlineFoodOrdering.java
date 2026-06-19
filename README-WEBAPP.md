# Burgers and Curry House - Online Food Ordering Web App

## Overview
This is a Spring Boot web application for online food ordering at "Burgers and Curry House".

## Features
- 🍔 Browse menu items (Burgers, Curry, Fries, Rice)
- 🛒 Add items to cart with quantity selector
- 💰 Special discount: Buy 3 Rice dishes, get $2 off
- 📱 Responsive design for desktop and mobile
- ✨ Beautiful modern UI with smooth interactions

## Tech Stack
- Spring Boot 3.1.5
- Java 11+
- Thymeleaf (Template Engine)
- CSS3 & JavaScript
- Maven

## Prerequisites
- Java 11 or higher
- Maven 3.6+

## Installation & Running Locally

### 1. Clone the repository
```bash
git clone https://github.com/californiagirllovesthesun/-Users-katiecarlson-Desktop-MenuOnlineFoodOrdering.java.git
cd -Users-katiecarlson-Desktop-MenuOnlineFoodOrdering.java
```

### 2. Build the project
```bash
mvn clean package
```

### 3. Run the application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Using Docker

### 1. Build the Docker image
```bash
mvn clean package
docker build -t burgers-curry-house .
```

### 2. Run with Docker Compose
```bash
docker-compose up
```

Access the app at `http://localhost:8080`

## Project Structure
```
src/
├── main/
│   ├── java/com/burgercurryhouse/
│   │   ├── FoodOrderingApplication.java (Main class)
│   │   ├── controller/
│   │   │   └── MenuController.java
│   │   └── model/
│   │       ├── MenuItem.java (Abstract base class)
│   │       ├── Burger.java
│   │       ├── Curry.java
│   │       ├── Fries.java
│   │       ├── Rice.java (with $2 discount for 3+)
│   │       └── OrderItem.java
│   └── resources/
│       ├── templates/
│       │   ├── index.html (Menu page)
│       │   └── order-confirmation.html
│       └── application.properties
├── pom.xml
├── Dockerfile
└── docker-compose.yml
```

## Features Explained

### OOP Principles Implemented
1. **Inheritance**: MenuItem base class with Burger, Curry, Fries, Rice subclasses
2. **Polymorphism**: Each MenuItem subclass overrides calculatePrice() method
3. **Rice Discount**: Special pricing logic for Rice (3+ items = $2 off)

### Web Interface
- Modern, responsive design
- Quantity selector with +/- buttons
- Order confirmation page with total calculation
- Discount notification for Rice orders

## Deployment Options

### Option 1: Heroku
1. Create a Procfile:
   ```
   web: java -Dserver.port=$PORT $JAVA_OPTS -jar target/food-ordering-system-1.0.0.jar
   ```
2. Push to Heroku

### Option 2: Railway.app
1. Connect your GitHub repository
2. Railway will auto-detect and deploy

### Option 3: Google Cloud Run
1. Build and push Docker image
2. Deploy from Container Registry

## API Endpoints

- `GET /` - Display menu
- `POST /order` - Process order
- `GET /menu` - Get menu as JSON

## Future Enhancements
- User authentication & accounts
- Persistent order history
- Payment integration
- Email notifications
- Admin dashboard
- Cart persistence

## Team
Team Charter - Group 5

## License
MIT License
