# Quiz Application

## Objective

The Quiz Application is a full-stack web application designed 
to create and manage quizzes. The primary goal of this project 
is to allows users to take quizzes on various topics. 
The application allows users to register, log in, create quizzes, 
attempt quizzes, and view their quiz scores.

## High-Level Overview

The Quiz Application follows a typical three-tier architecture, 
comprising the frontend/UI layer, backend/business logic layer, 
nd the data access layer.

1. Frontend/UI Layer (Controllers):
   - Responsible for the user interface and handling user interactions.
   - Users interact with the application through a web browser or mobile app.
   - Validates user input and sends requests to the backend for processing.
   - Communicates with the backend through API calls (HTTP requests).

2. Backend/Business Logic Layer (Service Layer):
    - Contains the core business logic of the application.
    - Orchestrates the overall flow of operations and handles complex tasks.
    - Acts as an intermediary between the frontend/UI layer and the data access layer.
    - Calls appropriate methods in the data access layer to interact with the database.
    - Provides data to the frontend/UI layer as a response to API calls.

3. Data Access Layer (Repository):
    - Responsible for data access and interactions with the database.
    - Provides a high-level API for performing CRUD operations on the database.
    - Abstracts away the database-specific code and interactions.
    - Retrieves data from the database and maps it to domain entities aka the data models.
    - Persists data to the database using appropriate data manipulation methods.

4. Database:
    - Stores user information, quizzes, questions, options, and user's answers.
    - Utilizes a relational database (e.g., MySQL, PostgreSQL) to maintain structured data.

## Technologies Used

- Frontend/UI: React.js, Thymeleaf (for server-side rendering)
- Backend: Spring Boot (Java), Spring Data JPA, Spring Security
- Database: MySQL (or your preferred relational database)
- State Management: Redux (or any state management library for React)
- Styling: CSS, Bootstrap (or any other CSS framework)

## Getting Started

To run the Quiz Application locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/quiz-app.git`
2. Set up the backend: Navigate to the `quiz-app-backend` folder and follow the instructions in the README to set up and run the Spring Boot application.
3. Set up the frontend: Navigate to the `quiz-app-frontend` folder and follow the instructions in the README to set up and run the React.js application.
4. Access the application: Once both the backend and frontend are running, open your web browser and visit `http://localhost:3000` to use the Quiz Application.

## Project Structure

The project is organized into two main directories:
- `quiz-app-backend`: Contains the Spring Boot backend code, including controllers, services, repositories, and the database configuration.
- `quiz-app-frontend`: Contains the React.js frontend code, including components, Redux store, and API interactions.

## Contributions

Contributions to this project are welcome! If you find any issues or have ideas for enhancements, feel free to open an issue or submit a pull request.

## License

